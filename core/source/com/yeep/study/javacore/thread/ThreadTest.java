package com.yeep.study.javacore.thread;

import java.util.Random;

public class ThreadTest implements Runnable
{
	private final static ThreadLocal studentLocal = new ThreadLocal();
	Student student = new Student();
	Integer integer = new Integer("1");

	public static void main(String[] agrs)
	{
		ThreadTest td = new ThreadTest();
		Thread t1 = new Thread(td, "a");
		Thread t2 = new Thread(td, "b");
		t1.start();
		t2.start();

	}

	public void run()
	{
		accessStudentWithoutThreadLocal();

		//accessStudentWithThreadLocal();
	}

	/**
	 * 没有使用Thread Local来保存Student变量，所以线程t1和t2的变量共享
	 */
	public void accessStudentWithoutThreadLocal()
	{
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");

		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("thread " + currentThreadName + " set age to:" + age);

		this.student.setAge(age);
		System.out.println("thread " + currentThreadName + " first  read age is:" + this.student.getAge());
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName + " second read age is:" + this.student.getAge());
	}

	/**
	 * 使用Thread Local来保存Student变量，所以线程t1和t2的变量不共享
	 */
	public void accessStudentWithThreadLocal()
	{
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");

		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("thread " + currentThreadName + " set age to:" + age);

		getStudent().setAge(age);
		System.out.println("thread " + currentThreadName + " first  read age is:" + getStudent().getAge());
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName + " second read age is:" + getStudent().getAge());
	}

	protected Student getStudent()
	{
		Student student = (Student) studentLocal.get();
		if (student == null)
		{
			student = new Student();
			studentLocal.set(student);
		}
		return student;
	}

	//	protected void setStudent(Student student)
	//	{
	//		studentLocal.set(student);
	//	}

}

class Student
{
	private int age = 0;

	public int getAge()
	{
		return this.age;

	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
