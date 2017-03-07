package com.ipartek.formacion;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.webservicex.biblia.BibleWebservice;
import net.webservicex.biblia.BibleWebserviceSoap;
import net.webservicex.biblia.GetBookTitles;
import net.webservicex.creditcard.CCChecker;
import net.webservicex.creditcard.CCCheckerSoap;
import net.webservicex.es.correos.oficinasbuzones.OficinasBuzones;
import net.webservicex.es.correos.oficinasbuzones.OficinasBuzonesSoap;
import net.webservicex.geoip.GeoIP;
import net.webservicex.geoip.GeoIPService;
import net.webservicex.geoip.GeoIPServiceSoap;
import net.webservicex.loan.FinanceService;
import net.webservicex.loan.FinanceServiceSoap;

public class Main {

	public static void main(String[] args) {
		/*if (validarTarjetaCredito()){
			System.out.println("es valida");
		}else{
			System.out.println("No es valida");
		}
		
		GeoIP geoip = obtenerIp();
		System.out.println("La ip es: "+geoip.getIP());
		geoip = obtenerPais(geoip.getIP());
		System.out.println("El pais es: "+geoip.getCountryName());
		//OBTENER TAR
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una cantidad: ");
		double loanAmount = entrada.nextDouble();
		System.out.println("Introduce el coste extra: ");
		double extraCost = entrada.nextDouble();
		System.out.println("Introduce el interes: ");
		double interestRate = entrada.nextDouble();
		System.out.println("Introduce los meses: ");
		double months = entrada.nextDouble();
			
		System.out.println("Valor del tae: "+obtenertae(loanAmount, extraCost, interestRate, months));
		System.out.println("Introduce el valor residual para calcular el pago mensual: ");
		double residualValue = entrada.nextDouble();
		System.out.println("pago mensual de alquiler: "+pagoMensualAlquiler(loanAmount, residualValue, interestRate, months));
		System.out.println("Pago mensual del credito: "+pagoMensualCredito(loanAmount, interestRate, months));
		System.out.println("Introduce el pago mensual para calcular el numero de pagos: ");
		double monthlyPayment = entrada.nextDouble();
		System.out.println("Numero de pagos del credito: "+numeroPagosCredito(loanAmount, interestRate, monthlyPayment));
		
		
		//CORREOS mostraremos todas las provincias
		Map<Integer, Provincia> provincias = getProvincias();
		for(Map.Entry<Integer, Provincia> entry: provincias.entrySet()){
			Integer code = entry.getKey();
			Provincia provincia = entry.getValue();
			System.out.println(provincia.toString());
		}
		*/
		//LISTA DE LIBROS DE LA BIBLIA
		Map<Integer, Libro> libros = getLibrosBiblia();
		for(Map.Entry<Integer, Libro> entry: libros.entrySet()){
			Integer code = entry.getKey();
			Libro libro = entry.getValue();
			System.out.println(libro.toString());
		}
	}

	private static boolean validarTarjetaCredito() {
		boolean valid = false;
		CCChecker cheker = new CCChecker();
		CCCheckerSoap soapcliente = cheker.getCCCheckerSoap();
		//Valida la tarjeta y devuelve un String
		String resultado = soapcliente.validateCardNumber("VISA", "444445556566777");
		if(resultado.contains("is valid")){
			valid = true;
		}
		return valid;
	}

	private static GeoIP obtenerIp(){
		GeoIP geoip = null;
		try{
			//Capa que crea la capacidad de instanciar
			GeoIPService cliente = new GeoIPService();
			GeoIPServiceSoap clientesoap = cliente.getGeoIPServiceSoap();
			geoip = clientesoap.getGeoIPContext();
		}catch(Exception e){
			
		}
		
		return geoip;
	}
	
	private static GeoIP obtenerPais(String ip){
		GeoIP geoip = null;
		try{
			GeoIPService cliente = new GeoIPService();
			GeoIPServiceSoap clientesoap = cliente.getGeoIPServiceSoap();
			geoip = clientesoap.getGeoIP(ip);
		}catch(Exception e){
			
		}
		return geoip;
	}
	
	//APR
	private static double obtenertae(double loanAmount, double extraCost, double interestRate, double months){
			double apr = 0.0;
		try{
			FinanceService servicio = new FinanceService();
			FinanceServiceSoap serviciosoap = servicio.getFinanceServiceSoap();
			apr = serviciosoap.apr(loanAmount, extraCost, interestRate, months);
		}catch(Exception e){
			
		}
		return apr;
	}
	
	//LEASEMONTHLYPAYMENT
	private static double pagoMensualAlquiler(double loanAmount, double residualValue, double interestRate, double months){
		double pago = 0.0;
		try{
			FinanceService servicio = new FinanceService();
			FinanceServiceSoap serviciosoap = servicio.getFinanceServiceSoap();
			pago = serviciosoap.leaseMonthlyPayment(loanAmount, residualValue, interestRate, months);
		}catch(Exception e){
			
		}
		return pago;
	}
	//LOANMOTNTHLYPAYMENT
	private static double pagoMensualCredito(double loanAmount, double interestRate, double months){
		double pago = 0.0;
		try{
			FinanceService servicio = new FinanceService();
			FinanceServiceSoap serviciosoap = servicio.getFinanceServiceSoap();
			pago = serviciosoap.loanMonthlyPayment(loanAmount, interestRate, months);
		}catch(Exception e){
			
		}
		return pago;
	}
	
	//LOANNUMBEROFPAYMENT
	private static double numeroPagosCredito(double loanAmount, double interestRate, double monthlyPayment){
		double pago = 0.0;
		try{
			FinanceService servicio = new FinanceService();
			FinanceServiceSoap serviciosoap = servicio.getFinanceServiceSoap();
			pago = serviciosoap.loanNumberOfPayment(loanAmount, interestRate, monthlyPayment);
		}catch(Exception e){
			
		}
		return pago;
	}
	
	
	//VER PROVINCIAS
	private static Map<Integer, Provincia> getProvincias() {
		Map<Integer, Provincia> provincias = null;
		OficinasBuzones cliente = new OficinasBuzones();
		OficinasBuzonesSoap clientesoap = cliente.getOficinasBuzonesSoap();
		String texto = clientesoap.consultaProvincias("ES");
		//Llamamos al metodo parseToMapProvincias
		provincias = parseToMapProvincias(texto);
		return provincias;
	}

	private static Map<Integer, Provincia> parseToMapProvincias(String texto) {
		Map<Integer, Provincia> provincias = null;
		//Esta clase es la que permite trabajar con tipos de datos XML
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		//el import es de dom (w3c)
		Document doc = null;
		try{
			//El docBuider se obtiene del docFactory
			docBuilder = docFactory.newDocumentBuilder();
			//Parseamos el String a XML
			//Elegimos el tipo de parse (inputSource) para que parsee del encoding Windows-1252 a el del codigo: UTF-8.
			//El origen de datos es un ByteArrayInputStream
			//getBytes recoge los datos 
			doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(texto.getBytes("Windows-1252"))));
			//Cuantas tags hay
			int len = doc.getElementsByTagName("provincia").getLength();
			Provincia provincia = null;
			provincias = new HashMap<Integer, Provincia>();
			//Ahora que sabemos cuantas son vamos a hacer el bucle
			for(int i = 0; i < len; i++){
				provincia = new Provincia();
				//Seleccionamos cada nodo y lo guardamos el prov
				Node prov = doc.getElementsByTagName("provincia").item(i);
				//Devuelve el nombre de la provincia
				provincia.setNombre(prov.getFirstChild().getNodeValue());
				//Cogemos todos los atributos del nodo
				NamedNodeMap attrs = prov.getAttributes();
				//me cojo el valor del item llamado id
				int codigo = Integer.parseInt(attrs.getNamedItem("id").getNodeValue());
				//Guarda el codigo de la provincia en provincia
				provincia.setCodigo(codigo);
				//De cada entrada de este tipo metemos el codigo y el nombre
				provincias.put(provincia.getCodigo(), provincia);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provincias;
	}
	
	//BIBLIA
	private static Map<Integer,Libro> getLibrosBiblia(){
		Map<Integer, Libro> libros = null;
		BibleWebservice servicio = new BibleWebservice();
		BibleWebserviceSoap serviciosoap = servicio.getBibleWebserviceSoap();
		//Se realiza la llamada a internet y guarda la respuesta como string
		String texto = serviciosoap.getBookTitles();
		//Ahora vamos a pasar el String a XML
		libros = parseToXMLMapLibros(texto);
		return libros;
	}

	private static Map<Integer, Libro> parseToXMLMapLibros(String texto) {
		Map<Integer, Libro> libros = null;
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		Document doc = null;
		try{
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(texto.getBytes())));
			int len = doc.getElementsByTagName("Table").getLength();
			Libro libro = null;
			libros = new HashMap<Integer, Libro>();
			for(int i = 0; i < len; i++){
				//CREAMOS UNA INSTANCIA LIBRO
				libro = new Libro();
				//COGEMOS LOS VALORES DEL NODO i Y LOS GUARDAMOS EN LA INSTANCIA LIBRO
				Node lib = doc.getElementsByTagName("BookTitle").item(i);
				libro.setTitulo(lib.getFirstChild().getNodeValue());
				lib = doc.getElementsByTagName("Book").item(i);
				libro.setCodigo(Integer.parseInt(lib.getFirstChild().getNodeValue()));
				//GUARDAMOS EL LIBRO EN EL MAPA
				libros.put(libro.getCodigo(), libro);
			}
		}catch(ParserConfigurationException e){
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}
}
