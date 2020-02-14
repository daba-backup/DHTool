package com.daxie.tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Methods to handle files.
 * @author Daba
 *
 */
public class FileFunctions {
	/**
	 * Returns all lines of a text file.
	 * @param is Input stream
	 * @param encoding Encoding of the file
	 * @return A list of strings split per line
	 * @throws IOException
	 */
	public static List<String> GetFileAllLines(InputStream is,String encoding) throws IOException{
		List<String> ret=new ArrayList<>();
		
		StringBuilder sb=new StringBuilder("");
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(is,encoding))) {
			String line;
			
			while(true) {
				line=br.readLine();
				if(line==null)break;
				
				sb.append(line);
				sb.append("\n");
			}
		}
		
		String[] lines=sb.toString().split("\n");
		for(String line:lines) {
			ret.add(line);
		}
		
		return ret;
	}
	/**
	 * Returns all lines of a text file.
	 * @param filename Filename to load
	 * @param encoding Encoding of the file
	 * @return A list of strings split per line
	 * @throws IOException
	 */
	public static List<String> GetFileAllLines(String filename,String encoding) throws IOException{
		List<String> ret;
		try(FileInputStream fis=new FileInputStream(filename)){
			ret=GetFileAllLines(fis, encoding);
		}
		
		return ret;
	}
	/**
	 * Returns all bytes of a binary file.
	 * @param is Stream
	 * @return A list of bytes
	 * @throws IOException
	 */
	public static List<Byte> GetFileAllBin(InputStream is) throws IOException{
		byte[] bs;
		try(BufferedInputStream bis=new BufferedInputStream(is)){
			bs=bis.readAllBytes();
		}
		
		int size=bs.length;
		List<Byte> bin=new ArrayList<>();
		
		for(int i=0;i<size;i++) {
			bin.add(bs[i]);
		}
		
		return bin;
	}
	/**
	 * Returns all bytes of a binary file.
	 * @param filename Filename to load
	 * @return A list of bytes
	 * @throws IOException
	 */
	public static List<Byte> GetFileAllBin(String filename) throws IOException{
		List<Byte> bin;
		try(FileInputStream fis=new FileInputStream(filename)){
			bin=GetFileAllBin(fis);
		}
		
		return bin;
	}
	/**
	 * Creates a text file.
	 * @param os Stream
	 * @param encoding Encoding
	 * @param lines Lines to write in the file
	 * @exception IOException
	 */
	public static void CreateTextFile(OutputStream os,String encoding,List<String> lines) throws IOException{
		try(BufferedWriter br=new BufferedWriter(new OutputStreamWriter(os,encoding))) {
			for(String line:lines) {
				br.write(line);
				br.newLine();
			}
			
			br.flush();
		}
	}
	/**
	 * Creates a text file.
	 * @param filename Filename
	 * @param encoding Encoding
	 * @param lines Lines to write in the file
	 * @exception IOException
	 */
	public static void CreateTextFile(String filename,String encoding,List<String> lines) throws IOException{
		try(FileOutputStream fos=new FileOutputStream(filename)){
			CreateTextFile(fos, encoding, lines);
		}
	}
	/**
	 * Creates a binary file.
	 * @param os Stream
	 * @param bin A list of bytes
	 * @exception IOException
	 */
	public static void CreateBinFile(OutputStream os,List<Byte> bin) throws IOException{
		try(BufferedOutputStream bos=new BufferedOutputStream(os)){
			for(Byte b:bin) {
				bos.write(b);
			}
		}
	}
	/**
	 * Creates a binary file.
	 * @param filename Filename
	 * @param bin A list of bytes
	 * @exception IOException
	 */
	public static void CreateBinFile(String filename,List<Byte> bin) throws IOException{
		try(FileOutputStream fos=new FileOutputStream(filename)){
			CreateBinFile(fos, bin);
		}
	}
}
