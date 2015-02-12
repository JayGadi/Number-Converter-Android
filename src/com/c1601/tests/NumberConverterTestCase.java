package com.c1601.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.c1601.assignment3.NumberConverter;

public class NumberConverterTestCase {
	
	//test for empty literal 
	@Test
	public void testEmptyString(){
		NumberConverter nc = new NumberConverter();
		assertEquals("error",nc.toDecimal(""));
		assertEquals("error", nc.toBinary(""));
		assertEquals("error",nc.toHex(""));
		
	}
	
	//test for wrong conversion prefix, i.e x: instead of d:/h:/b:
	@Test
	public void testWrongPrefix(){
		NumberConverter nc = new NumberConverter();
		assertEquals("error", nc.toDecimal("x:10"));
		assertEquals("error",nc.toBinary("x:10"));
		assertEquals("error",nc.toHex("x:10"));
		
	}
	
	//test decimal conversion
	@Test
	public void testToDecimal() {
		NumberConverter nc = new NumberConverter();
		assertEquals("554", nc.toDecimal("d:554"));
		assertEquals("554", nc.toDecimal("h:22A"));
		assertEquals("554", nc.toDecimal("b:1000101010"));
	}

	//test binary conversion
	@Test
	public void testToBinary() {
		NumberConverter nc = new NumberConverter();
		assertEquals("1000101010", nc.toBinary("d:554"));
		assertEquals("1000101010", nc.toBinary("h:22A"));
		assertEquals("1000101010", nc.toBinary("b:1000101010"));
	}

	//test hex conversion
	@Test
	public void testToHex() {
		NumberConverter nc = new NumberConverter();
		assertEquals("22A", nc.toHex("d:554"));
		assertEquals("22A", nc.toHex("h:22A"));
		assertEquals("22A", nc.toHex("b:1000101010"));

	}

}
