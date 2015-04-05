package junit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import business.parser.impl.Parser;
import business.parser.impl.ParserGIFT;
import business.parser.impl.ParserQTI;
import business.parser.impl.ParserXML;
import business.preguntas.Pregunta;

public class ParserTest {

	@Test
	public void testGIFT() {
		File file = null;
		
		ArrayList<String> rFalsas1 = new ArrayList<String>();
		rFalsas1.add("El sostén"); rFalsas1.add("De en medio"); rFalsas1.add("El vestido azul y negro, o es blanco y dorado?");
		Pregunta p1 = new Pregunta("Q1", "Ay que se quite...", rFalsas1, "El top");
		
		ArrayList<String> rFalsas2 = new ArrayList<String>();
		rFalsas2.add("2"); rFalsas2.add("3.14159"); rFalsas2.add("Soy de magisterio, no se sumar.");
		Pregunta p2 = new Pregunta("Q2", "�Cuando fue 1+1", rFalsas2, "El fant�stico Ralph!");
		try {
			file = File.createTempFile("giftTest", ".gift");
		} catch (IOException e) {
			e.printStackTrace();
			fail("El  fichero de pruebas no pudo ser creado");
		}
		try {			
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath(), true)));
		    out.println("::" + p1.getID() + "::");
		    out.println(p1.getPregunta() + " {");
		    out.println("~" + p1.getRespuestasIncorrectas().get(0));
		    out.println("=" + p1.getRespuestaCorrecta());
		    out.println("~" + p1.getRespuestasIncorrectas().get(1));
		    out.println("~" + p1.getRespuestasIncorrectas().get(2));
		    out.println("}");
		    out.println("::" + p2.getID() + "::");
		    out.println(p2.getPregunta() + " {");
		    out.println("~" + p2.getRespuestasIncorrectas().get(0));
		    out.println("~" + p2.getRespuestasIncorrectas().get(1));
		    out.println("=" + p2.getRespuestaCorrecta());    
		    out.println("~" + p2.getRespuestasIncorrectas().get(2));
		    out.println("}");
		    out.close();
		    System.out.println(file.toString());
		} catch (Exception e) {
		    e.printStackTrace();
		    fail("No se pudo escribir en el fichero temporal.");
		}
		Parser p = new ParserGIFT(file.getAbsolutePath());
		HashMap<String, Pregunta> resultado = null;
		try {
			resultado = p.getPregunta();
		} catch (IOException e) {
			e.printStackTrace();
			fail("No se pudo leer el fichero temporal.");
		}
		assertTrue(resultado.get(p1.getID()).equals(p1));
		assertTrue(resultado.get(p2.getID()).equals(p2));
	}
	@Test
	public void testXML() {
		File file = null;
		
		ArrayList<String> rFalsas1 = new ArrayList<String>();
		rFalsas1.add("El sost�n"); rFalsas1.add("De en medio"); rFalsas1.add("El vestido azul y negro, o es blanco y dorado?");
		Pregunta p1 = new Pregunta("Q1", "Ay que se quite...", rFalsas1, "El top");
		
		ArrayList<String> rFalsas2 = new ArrayList<String>();
		rFalsas2.add("2"); rFalsas2.add("3.14159"); rFalsas2.add("Soy de magisterio, no se sumar.");
		Pregunta p2 = new Pregunta("Q2", "�Cuando fue 1+1", rFalsas2, "El fant�stico Ralph!");
		try {
			file = File.createTempFile("xmlTest", ".xml");
		} catch (IOException e) {
			e.printStackTrace();
			fail("El  fichero de pruebas no pudo ser creado");
		}
			//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath(), true)))) {
			BufferedWriter out = null;
			try {
				out = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()),"UTF-8"));
				out.write("<cuestionario>");
				out.write("<pregunta id=\"" + p1.getID() + "\">");
				out.write("<textoPregunta>"+p1.getPregunta()+"</textoPregunta>");
				out.write("<respuestaIncorrecta>" + p1.getRespuestasIncorrectas().get(0) + "</respuestaIncorrecta>");
				out.write("<respuestaIncorrecta>" + p1.getRespuestasIncorrectas().get(2) + "</respuestaIncorrecta>");
				out.write("<respuestaIncorrecta>" + p1.getRespuestasIncorrectas().get(1) + "</respuestaIncorrecta>");
				out.write("<respuestaCorrecta>" + p1.getRespuestaCorrecta() + "</respuestaCorrecta>");
				out.write("</pregunta>");
				out.write("<pregunta id=\"" + p2.getID() + "\">");
				out.write("<textoPregunta>" + p2.getPregunta() + "</textoPregunta>");
				out.write("<respuestaCorrecta>" + p2.getRespuestaCorrecta() + "</respuestaCorrecta>");
				out.write("<respuestaIncorrecta>" + p2.getRespuestasIncorrectas().get(0) + "</respuestaIncorrecta>");
				out.write("<respuestaIncorrecta>" + p2.getRespuestasIncorrectas().get(2) + "</respuestaIncorrecta>");
				out.write("<respuestaIncorrecta>" + p2.getRespuestasIncorrectas().get(1) + "</respuestaIncorrecta>");
				out.write("</pregunta>");
				out.write("</cuestionario>");
				out.close();
			} catch (IOException e1) {
				fail("No se puede escribir en el fichero de pruebas");
				e1.printStackTrace();
			}
		
		Parser p = new ParserXML(file.getAbsolutePath());
		HashMap<String, Pregunta> resultado = null;
		try {
			resultado = p.getPregunta();
		} catch (IOException e) {
			e.printStackTrace();
			fail("No se pudo leer el fichero temporal.");
		}
		assertTrue(resultado.get(p1.getID()).equals(p1));
		assertTrue(resultado.get(p2.getID()).equals(p2));
	}
	@Test
	public void testQTI() {
		File file = null;
		
		ArrayList<String> rFalsas1 = new ArrayList<String>();
		rFalsas1.add("El sost�n"); rFalsas1.add("De en medio"); rFalsas1.add("El vestido azul y negro, o es blanco y dorado?");
		Pregunta p1 = new Pregunta("Q1", "Ay que se quite...", rFalsas1, "El top");
		
		ArrayList<String> rFalsas2 = new ArrayList<String>();
		rFalsas2.add("2"); rFalsas2.add("3.14159"); rFalsas2.add("Soy de magisterio, no se sumar.");
		Pregunta p2 = new Pregunta("Q2", "�Cuando fue 1+1", rFalsas2, "El fant�stico Ralph!");
		try {
			file = File.createTempFile("qtiTest", ".xml");
		} catch (IOException e) {
			e.printStackTrace();
			fail("El  fichero de pruebas no pudo ser creado");
		}
			//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath(), true)))) {
			BufferedWriter out = null;
			try {
				out = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()),"UTF-8"));
				out.write("<assessmentItem xmlns=\"http://www.imsglobal.org/xsd/imsqti_v2p1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.imsglobal.org/xsd/imsqti_v2p1 http://www.imsglobal.org/xsd/qti/qtiv2p1/imsqti_v2p1.xsd\" identifier=\"choice\" title=\"Unattended Luggage\" adaptive=\"false\" timeDependent=\"false\">");
				out.write("<responseDeclaration identifier=\"" + p1.getID() + "\" cardinality=\"single\" baseType=\"identifier\"><correctResponse><value>ChoiceA</value></correctResponse></responseDeclaration>");
				out.write("<responseDeclaration identifier=\"" + p2.getID() + "\" cardinality=\"single\" baseType=\"identifier\"><correctResponse><value>ChoiceB</value></correctResponse></responseDeclaration>");
				out.write("<itemBody>");
				out.write("<choiceInteraction responseIdentifier=\""+p1.getID()+"\" shuffle=\"false\" maxChoices=\"1\">");
				out.write("<prompt>" + p1.getPregunta() + "</prompt>");
				out.write("<simpleChoice identifier=\"ChoiceA\">" + p1.getRespuestaCorrecta() + "</simpleChoice>");
				out.write("<simpleChoice identifier=\"ChoiceB\">" + p1.getRespuestasIncorrectas().get(0) + "</simpleChoice>");
				out.write("<simpleChoice identifier=\"ChoiceC\">" +  p1.getRespuestasIncorrectas().get(1) + "</simpleChoice>");
				out.write("<simpleChoice identifier=\"ChoiceD\">" + p1.getRespuestasIncorrectas().get(2) + "</simpleChoice>");
				out.write("</choiceInteraction>");
				out.write("</itemBody>");
				out.write("<itemBody>");
				out.write("<choiceInteraction responseIdentifier=\""+p2.getID()+"\" shuffle=\"false\" maxChoices=\"1\">");
				out.write("<prompt>" + p2.getPregunta() + "</prompt>");
				out.write("<simpleChoice identifier=\"ChoiceA\">" + p2.getRespuestasIncorrectas().get(0) + "</simpleChoice>");
				out.write("<simpleChoice identifier=\"ChoiceB\">" + p2.getRespuestaCorrecta() + "</simpleChoice>");
				out.write("<simpleChoice identifier=\"ChoiceC\">" +  p2.getRespuestasIncorrectas().get(1) + "</simpleChoice>");
				out.write("<simpleChoice identifier=\"ChoiceD\">" + p2.getRespuestasIncorrectas().get(2) + "</simpleChoice>");
				out.write("</choiceInteraction>");
				out.write("</itemBody>");
				out.write("</assessmentItem>");
				
				out.close();
			} catch (IOException e1) {
				fail("No se puede escribir en el fichero de pruebas");
				e1.printStackTrace();
			}
		
		Parser p = new ParserQTI(file.getAbsolutePath());
		HashMap<String, Pregunta> resultado = null;
		try {
			resultado = p.getPregunta();
		} catch (IOException e) {
			e.printStackTrace();
			fail("No se pudo leer el fichero temporal.");
		}
		assertTrue(resultado.get(p1.getID()).equals(p1));
		assertTrue(resultado.get(p2.getID()).equals(p2));
	}
}
