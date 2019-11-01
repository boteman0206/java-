package com.example.demo;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapred.Reporter;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by xcl on 2019/7/22 16:02.
 */
public class HDFSUtils {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	/**
	 * 文件系统连接到 hdfs的配置信息
	 */
	private static Configuration getConf() {
		// 创建配置实例
		Configuration conf = new Configuration();
		// 这句话很关键，这些信息就是hadoop配置文件中的信息
		conf.set("fs.defaultFS", "hdfs://nameservice1");

		return conf;
	}

	/**
	 * 创建文件系统实例
	 *
	 * @return
	 * @throws IOException
	 */
	public static FileSystem createFileSystem() throws IOException {
		// 创建文件系统实例
		Configuration conf = getConf();
		FileSystem fs = FileSystem.get(conf);

		return fs;
	}


	/**
	 * 创建新的HDFS文件
	 *
	 * @param toCreateFilePath
	 * @param content
	 * @throws IOException
	 */
	public static void createNewHDFSFile(String toCreateFilePath, String content) throws IOException {
		// 创建文件系统实例
		FileSystem fs = createFileSystem();

		// 创建输出流实例
		FSDataOutputStream os = fs.create(new Path(toCreateFilePath));
		// 写入UTF-8格式字节数据
		os.write(content.getBytes("UTF-8"));

		// 关闭连接
		os.close();
		fs.close();
	}

	/**
	 * 创建新的HDFS文件【共用HDFS文件系统实例】
	 *
	 * @param toCreateFilePath
	 * @param content
	 * @throws IOException
	 */
	public static void createNewHDFSFile(FileSystem fs,String toCreateFilePath, String content) throws IOException {
		// 创建文件系统实例
		//FileSystem fs = createFileSystem();

		// 创建输出流实例
		FSDataOutputStream os = fs.create(new Path(toCreateFilePath));
		// 写入UTF-8格式字节数据
		os.write(content.getBytes("UTF-8"));

		// 关闭连接
		os.close();
		//fs.close();
	}

	/**
	 * 复制本地文件到HDFS
	 *
	 * @param toCreateFilePath
	 * @param localFilePath
	 * @throws IOException
	 */
	public static void copytoHDFSFile(String toCreateFilePath, String localFilePath) throws IOException {
		// 读取本地文件
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(localFilePath));

		// 创建文件系统实例
		FileSystem fs = createFileSystem();

		// 创建HDFS输出流实例
		FSDataOutputStream os = fs.create(new Path(toCreateFilePath));

		// 两种方式其中的一种一次读写一个字节数组
		byte[] bys = new byte[128000000];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			os.write(bys, 0, len);
			os.hflush();
		}

		// 关闭连接
		os.close();
		fs.close();
	}


	/**
	 * 读取文件
	 *
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public static byte[] readHDFSFile(String filename) throws Exception  {
		// 创建文件系统实例
		FileSystem fs = createFileSystem();

		// 创建路径实例
		Path readPath = new Path(filename);

		//  检查文件是否存在
		if (fs.exists(readPath))  {
			FSDataInputStream is = fs.open(readPath);
			// 获取文件信息，以便确定buffer大小
			FileStatus stat = fs.getFileStatus(readPath);

			// 创建buffer
			byte[] buffer = new byte[Integer.parseInt(String.valueOf(stat.getLen()))];

			// 读取全部数据，存入buffer
			is.readFully(0, buffer);

			// 关闭连接
			is.close();
			fs.close();

			// 返回读取到的数据
			return buffer;
		}else{
			throw new Exception("the file is not found .");
		}
	}


	/**
	 * 目录是否存在
	 *
	 * @param dir
	 * @throws IOException
	 */
	public static boolean isExist(FileSystem fs,String dir) throws IOException  {
		// 创建文件系统实例
		//FileSystem fs = createFileSystem();

		return fs.exists(new Path(dir));
	}

	/**
	 * 删除目录下的文件
	 *
	 * @param dirs
	 * @throws IOException
	 */
	public static void rmDirs(FileSystem fs,List<String> dirs) throws IOException  {
		// 创建文件系统实例
		//FileSystem fs = createFileSystem();

		// 遍历目录，删除（递归删除）
		for(int i=0;i<dirs.size();i++){
			Path path = new Path(dirs.get(i));
			fs.delete(path,true);
		}

		// 关闭文件连接
		//fs.close();
	}

	/**
	 * 删除Hive的分区目录
	 *
	 * @param fs
	 * @param hiveTable
	 * @param dirs
	 * @throws IOException
	 */
	public static void dropPartitions(FileSystem fs,String hiveTable,List<String> dirs) throws IOException  {
		// 创建文件系统实例
		//FileSystem fs = createFileSystem();

		// 拼接Hive存储目录
		String hiveTablePath = "/user/hive/warehouse/".concat(hiveTable.replace(".",".db/")).concat("/");

		// 遍历目录，删除（递归删除）
		for(int i=0;i<dirs.size();i++){
			Path path = new Path(hiveTablePath.concat(dirs.get(i)));
			fs.delete(path,true);
			logger.info("删除路径{}完毕",path.toString());
		}

		// 关闭文件连接
		//fs.close();
	}

	/**
	 * 创建目录
	 * @param dir
	 * @throws IOException
	 */
	public static void mkdir(FileSystem fs,String dir) throws IOException  {
		// 创建文件系统实例
		//FileSystem fs = createFileSystem();

		// 创建路径
		fs.mkdirs(new Path(dir));

		// 关闭文件连接
		//fs.close();
	}


	/**
	 * 列出目录
	 *
	 * @param dir
	 * @throws IOException
	 */
	public static void listAll(FileSystem fs,String dir) throws IOException {
		// 创建文件系统实例
		//FileSystem fs = createFileSystem();

		// 获取目录列表
		FileStatus[] stats = fs.listStatus(new Path(dir));
		// 遍历打印
		for(int i = 0; i < stats.length; ++i) {
			if (!stats[i].isDir()){
				// regular file
				System.out.println(stats[i].getPath().toString());
			}else{
				// dir
				System.out.println(stats[i].getPath().toString());
			}
		}

		// 关闭文件连接
		fs.close();
	}

	/**
	 * Test
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		//getDateNodeHost();

		//uploadLocalFile2HDFS("E:/1.txt","/tmp/1.txt");//E盘下文件传到hdfs上

		//createNewHDFSFile("/tmp/create2", "hello");
		//copytoHDFSFile("/tmp/create2", "C://user_visit_action.txt");
		//System.out.println(new String(readHDFSFile("/tmp/create2")));
		//readHDFSFile("/tmp/create2");
		//deleteHDFSFile("/tmp/create2");

		//mkdir("/tmp/testdir");
		//deleteDir("/tmp/testdir");
		//listAll("/tmp/");

		//System.out.println(isExist("/user/hive/warehouse/raw.db/project_kcc_shop_comment_test/1"));

//		long start = System.currentTimeMillis();
//		FileSystem fs = createFileSystem();
//		long stop = System.currentTimeMillis();
//
//		System.out.println("创建文件系统耗时" + (stop-start) + "毫秒");
//		fs.close();
//		long stop2 = System.currentTimeMillis();
//		System.out.println("关闭文件系统耗时" + (stop2-stop) + "毫秒");

        FileSystem fileSystem = createFileSystem();
        System.out.println(fileSystem);


    }




}
