##########################
######## 项目说明 ########
##########################

1.本项目包含四个大模块 yeep_database, yeep_core, yeep_war，yeep_gwt

  yeep_database模块中包含着本项目所用到的数据库操作的sql文件
  
  yeep_core模块是本项目的核心模块，包含了所有类文件、hibernate配置文件、Spring配置文件
  
  yeep_war模块是本项目的WebApplication模块，包含了所用到的页面文件(jsp,css,js), 以及web.xml配置文件
  
  yeep_gwt模块包含了gwt的应用
  
  
2.本项目的打包和发布都运用Ant来实现，运行Ant的相关说明可以完成模块的编译、打包和发布  


#########################
##### Ant 配置说明 ######
#########################

1.本项目的Ant配置如下:

  主目录：   build-shared.xml,build.xml,build.properties
  database:  build-database.xml,database.properties
  studyCore: build-core.xml
  study_war: build-war.xml
  
  配置文件的包含关系:build-shared.xml定义了共用的定义,主目录的build.xml文件包含了其余子目录的build文件，子配置文件的是子模块的各项任务，主配置文件完成协调各个子任务的关系，完成项目的打包和发布。


2.配置文件说明:

  主目录：build.xml 包含了主要任务 build-war 
  			build-war 完成项目的打包和发布工作
  			          (1)执行 build-core.xml中的all任务
  			          (2)执行 build-war.xml中的all任务
  			          (3)yeep_core中build/classes中的编译完成的类copy到study-war中的./WEB-INF/classes目录
  
  database:  build-database.xml 包含2个主要任务 db-create 和 db_drop
			 
			 db-create 创建数据库
			 db_drop 删除数据库
			 
			 我们可以单独运行这2个任务来实现数据库的创建和删除,注:build-database.xml引用到了database.properties中的数据库配置
  
  core: build-core.xml 包含了3个主要任务 all、clean-directory、create-directory、compile、config
			
			all	完成清除目录和创建目录，分别执行clean-directory、create-directory、compile、config任务
			clean-directory 清除目录 (./build/*)
			create-directory 创建目录 (./build/*)
			compile 编译source中的所有类文件，并放入./build/classes目录
			config 将config中的配置文件copy到./build/config目录
			 
  war: build-war.xml 包含了3个主要任务 all、clean-directory 和 create-directory
			
			all	完成清除目录和创建目录，首先会执行clean-directory，然后执行create-directory
			clean-directory 清除目录 (./WEB-INF/classes)
			create-directory 创建目录 (./WEB-INF/classes)
  
  gwt:build-gwt.xml 包含了2个主要任务 compile, compile-client
		   
		   compile 编译所有yeep_gwt的代码
		   compile-client 编译所有代码，并且copy到war的相应目录下
  
  

#########################
####### 代码说明 ########
#########################

##### Ajax #####
1.Ajax 例子 : /jsp/ajax目录中包含了简单的ajax的示例
  运行: http://localhost:18080/yeep/jsp/study/ajax/*.jsp



##### JSTl #####
1.JSTl 例子: jsp/jstl目录下包括了jstlSample.jsp(jstl tag例子)
  运行: http://localhost:18080/yeep/jsp/study/jstl/*.jsp


##### Javascript #####

1.Prototype
jsp/javascript/prototype目录存放了prototype.js的例子
运行: http://../yeep/jsp/study/javascript/prototype/*.jsp

(1)dollarSample.jsp: $( ),$F( ),$A( ),$H( ),$R( ) 方法的使用

	$()方法是document.getElementById()方法的一个便利的简写，就像这个DOM方法一样，这个方法返回参数传入的id的那个元素。你可以传入多个id作为参数然后 $() 返回一个带有所有要求的元素的一个 Array 对象。
	$F()方法是另一个非常受欢迎的简写。它可以返回任何输入表单控件的值，如文本框或下拉框。 这个方法可以传入元素的id或者元素自己。
	$A()方法把接收到的参数转换成一个Array对象。这个方法加上对Array类的扩展，可以很容易的转换或者复制任意的列举列表到Array对象
	$H()方法把对象转化成可枚举的貌似联合数组Hash对象。
	$R()方法是new ObjectRange(lowerBound, upperBound, excludeBounds)的一个简单快捷的使用方式。
	Try.these() 方法使得实现当你想调用不同的方法直到其中的一个成功正常的这种需求变得非常容易， 他把一系列的方法作为参数并且按顺序的一个一个的执行这些方法直到其中的一个成功执行，返回成功执行的那个方法的返回值。	

(2)ajaxSample1_1.jsp:简单的利用prototype.js的Ajax响应
	
	URL:http://localhost:18080/study/jsp/javascript/prototype/sampleAjax1_2.jsp?username= 返回数据
	用 Ajax.Request对象和服务器通信并且得到这段XML是非常简单的，参数{method: 'post', parameters: pars, onComplete: showResponse} 表示一个匿名对象的真实写法。他表示你传入的这个对象有一个名为 method 值为 'post'的属性，另一个属性名为 parameters 包含HTTP请求的查询字符串，和一个onComplete 属性/方法包含函数showResponse。还有一些其它的属性可以在这个对象里面定义和设置，如 asynchronous，可以为true 或 false 来决定AJAX对服务器的调用是否是异步的（默认值是 true）。这个参数定义AJAX调用的选项。
	
	在我们的例子中，在第一个参数通过HTTP GET命令请求那个url，传入了变量 pars包含的查询字符串， Ajax.Request 对象在它完成接收响应的时候将调用showResponse 方法。XMLHttpRequest在HTTP请求期间将报告进度情况。这个进度被描述为四个不同阶段：Loading, Loaded, Interactive, 或 Complete。你可以使 Ajax.Request 对象在任何阶段调用自定义方法 ，Complete 是最常用的一个。想调用自定义的方法只需要简单的在请求的选项参数中的名为 onXXXXX 属性/方法中提供自定义的方法对象。 就像我们例子中的 onComplete 。你传入的方法将会被用一个参数调用，这个参数是 XMLHttpRequest 对象自己。你将会用这个对象去得到返回的数据并且或许检查包含有在这次调用中的HTTP结果代码的 status 属性。还有另外两个有用的选项用来处理结果。我们可以在onSuccess 选项处传入一个方法，当AJAX无误的执行完后调用， 相反的，也可以在onFailure选项处传入一个方法，当服务器端出现错误时调用。正如onXXXXX 选项传入的方法一样，这两个在被调用的时候也传入一个带有AJAX请求的XMLHttpRequest对象。

	
	如果你的服务器的另一端返回的信息已经是HTML了，那么使用Ajax.Updater 类操作更加得容易。用它你只需提供哪一个元素需要被AJAX请求返回的HTML填充就可以了，

(3)otherSample.jsp:显示了自定义Class和Observer的用法


2.Javascript变量使用
jsp/javascript/jsFunctionSample.jsp 实现了javascript函数的使用
(1)函数的定义,有以下四种方法(但它们使用有很大的区别)：
		a.function add(x,y){return x+y;}
		b.var add = function(x,y){return x+y;}
		c.var add = new Function("x","y","return x+y;");
		d.var add =function a(x,y){return x+y;}

(2)函数的参数:在一个函数体内，标识符arguments有特殊含义,它是调用对象的一个特殊属性。
		arguments.length and arguments[index]可以在函数内被调用，但建议你不要在函数内改变它们(虽然可以被修改)。
		arguments还有个属性 callee.引用当前正在执行的函数。
		
(3)函数--数据类型:在javascript中，函数可以象字符串、数字、日期一样当成一种数据。
    var add=function(x,y){return x+y;};其实我们函数的定义都是把函数附值给变量。函数不但可以附值给变量，还可以当成参数传递。
		其实我们把函数定义在全局变量的属性字段中。如
    	var  MyLib =  {} ;
  		MyLib.fun1 = function ()  {} ;
  		MyLib.fun2 = function ()  {} ;
		这样就基本不会和其他代码发生命名上的冲突了。

(4)函数的生命周期:在变量里函数有个预编译过程，这个过程我们也看到不到，另外函数定义不同写法情况也不同。

		以下fun1能被调用，而fun2和fun3都不能，不同定义的写法情况是不同的 (fun1这样定义是被预先编译了，所以可以在fun1定义前使用它)
  	    fun1();
        fun2();
  	    fun3();

		function  fun1()  {} 
		var fun2 = function ()  {} ;
		var fun3 = new Function( "" );


3.Javascript对象使用
(1)jsp/javascript/jsObjectSample1.jsp 实现了 javascript创建对象的方式
  (a)var obj = new Object();
      
  (b)var obj =
     {
     	name:'xxx',
		age:yyy,
		desc:function(){...}
     }

  (c)function CustomerObject(){};
     var obj = new CustomerObject();
	 new Object(),new function()同等级;new function()继承了Object的prototype,也会继承 function的prototype


(2)jsp/javascript/jsObjectSample2.jsp 实现了 javascript 使用对象属性的方式
	类的属性可以是方法，也可以指字段。在一个自定义“类”中有中有几个地方可以定义属性。
   (a)函数名中直接定义。如Person.name。在这定义相当于类名的属性。静态的，访问的时候必须用Person.name来访问，不能用new Person().name访问，也访问不到。
   (b)构造函数的this.中。当你用new function()时，这些属性就是你所持对象的属性。用new Person().属性  来访问。
   (c)构建好对象以后，给对象增加属性。和构造函数中的属性使用类似。
   (d)函数名的prototype中
   (e)父类或Object的prototype中


(3)jsp/javascript/jsObjectSample3.jsp实现了用javascript继承的两种方式:
   (a)将某个类定义成子类的方法, 通过在负责定义子类函数的内部调用超类的构造函数
   (b)建立一个超类对象, 然后将其赋值给子类对象的 prototype 属性, 以此方式来建立子类的继承

4. javascript的正则表达式
   jsp/javascript/regexp/regularExpressionSample.jsp 实现了用javascript完成数字校验的正则表达式的应用

5. Javascript DOM: /jsp/javascript/dom目录中包含了简单的dom的示例
   
	页面的所有元素在DOM中被定义成Node，我们可以根据Node.nodeType来区分类型:
		element node --> nodeType = 1, eg. <html>,<body>, etc.
		text node    --> nodeType = 2, eg. <p>text content</p>(<p></p>节点内的文本内容)
		属性节点     --> nodeType = 3, eg. <p title="Title1"> (title="Title1"就是一个属性节点)
		
	DOM提供了getElementById(id),getElementByTagName(name),getElementByName(name),getAttribute(),setAttribute方法来完成对页面元素的操作

(1)domSample1_1.jsp 展示了遍历HTML中的全部元素，利用child来获取Document对象的子对象
(2)domSample2_1.jsp 展示了创建、删除Table等元素节点的操作
(3)domSample3_1.jsp	展示了innerHTML,outterHTML和innerText的用法   
(4)domSample4_1.jsp	展示了Javascritp获取XML数据 	




##### Struts1 ##### 
注意:由于上下文和相对路径的问题, 所有Struts的例子都使用http://../yeep/strutsSample.do?forward=*** 来调用所有的例子

配置文件:struts-config.xml有web.xml加载,本例子有spring来控制所有的action,所以采用plug-in的方式加载了applicationContext-struts-action.xml

(1)DispatchAction:本例测试了Struts中DispatchAction的方法分配，使用http://.../yeep/strutsSample.do?forward=dispatchTest来访问
      当url中method的方法没有指定的情况下，会默认调用unspecified方法。在struts-config.xml中定义了com.study.struts.action.DispatchActionTestAction，在url中可以通过 http://.../study/dispatchActionTest.do?method=yyy来访问
	
(2)Struts and Ajax:本例展示了Ajax和Struts的混合运用，可以通过http://.../yeep/strutsSample.do?forward=ajaxSample来访问
   在/jsp/study/struts1/strutsAjaxSample.jsp中利用prototype.js来监听下拉菜单，并触发StrutsAjaxSampleAction，返回给页面查询到的结果


(3)Struts DynaForm:本例展示运用Struts的DynaForm来实现动态form的使用,可以通过http://.../yeep/strutsSample.do?forward=dynaFormTest来访问



###################
##### Struts2 ##### 
###################
1. Struts2 简介
   Struts2按照技术细节划分，主要分为以下几块。
   标签库：在视图中运用这些标签来实现网页上各种格式的显示。
   拦截器：HTTP请求在进入控制器部分执行前先执行拦截器中的功能。
   FilterDispatcher和Action：接收HTTP请求，根据Action的ActionMapper决定调用Action哪些方法。
   Struts2配置文件：定义控制转发流程，每个Action类的处理和结果数据如何导航到相应表示界面都由它定义。
   OGNL和类型转化：在表示界面将包含数据的Java对象进行类型转化，显示出符合页面规则的数据格式。
   Struts2校验规则：对数据输入的严格定义，保证没有垃圾数据和不符合项目需求的数据。
   国际化和本地化：针对字符编码的转化，让Web项目显示各种语言版本。

2. 拦截器 Interceptor:在struts.xml文件中可以配置我们自定义的拦截器
   例如:<interceptors>
			<interceptor name="generalInterceptorExample"
				class="com.yeep.struts2Study.interceptor.GeneralInterceptorExample">
				<param name="parameter">testParameter</param>
			</interceptor>
			<interceptor-stack name="sampleStack">
				<interceptor-ref name="generalInterceptorExample"></interceptor-ref>
				<interceptor-ref name="defaultStack"></interceptor-ref>
			</interceptor-stack>
		</interceptors>
   (1)在xml配置文件中配置拦截器和拦截器栈都是以“<interceptors>”开头，以“</interceptors>”结尾。
   (2)配置拦截器的格式如上面代码所示以“<interceptor/>”格式显示，其中两个属性name是拦截器名字，另一个是对应的类路径, 也可以添加自定义的参数<param/>
   (3)拦截器栈的格式是以“<interceptor-stack >”开头，以“</interceptor-stack>”结尾。其中属性name是拦截器栈名字。在“<interceptor-stack >”和“</interceptor-stack>”之间可以设置拦截器。如代码所示格式为“<interceptor-ref />”，其中name属性也是拦截器名字。
      注意：拦截器栈中不单单可以配置拦截器，它甚至还可以配置拦截器栈。比如在“sampleStack” 拦截器栈中就配置了“defaultStack”拦截器栈。这样的话，配置的子拦截器栈中的拦截器也会被执行。
   
   在Action中配置拦截器，有如下两种:
    <action ...>
	    ...
		<interceptor-ref name="generalInterceptorExample">
			<param name="parameter">newTtestParameter</param>
		</interceptor-ref>
		<interceptor-ref name="defaultStack"></interceptor-ref>
	</action>
	在Action上显示的配置“generalInterceptorExample”和“defaultStack”两个拦截器或拦截器堆栈。
	
	<action ...>
	    ...
		<interceptor-ref name="sampleStack"></interceptor-ref>
	</action>
	在Action上显示的配置“sampleStack”这个拦截器堆栈，达到和第一种配置相同的效果，因为在定义“sampleStack”的时候已经包含了“generalInterceptorExample”和“defaultStack”。
	注意：如果在<Action>中不配置“defaultStack”拦截器栈，则Login.action运行时候只会执行配置的“generalInterceptorExample”拦截器，不会执行“defaultStack”拦截器栈。而且“defaultStack”是Struts2配置的缺省拦截器栈。
	      Struts2规定如果在<Action>中,开发人员配置了自己定义的拦截器或拦截器栈，不显式在struts.xml配置文件中配置“defaultStack”拦截器栈，则所有struts-default.xml中定义的拦截器都不会执行即不执行“defaultStack”拦截器栈。当然如果在<Action>中开发人员没有配置自己定义的拦截器或拦截器栈，就算不显示配置“defaultStack”拦截器栈，则“defaultStack”拦截器栈是会执行的。

3. 上传文件: 运行http://localhost:18080/struts2/jsp/upload.jsp
　　其实还可以指定上传文件的格式，让它只上传特定类型的文件。比如只能上传文本和xml文件，则在struts.xml需要显示配置“uploadFile”拦截器。
　　定义了一个名为“allowedTypes”的参数，其中在<param></param>之间的是文件类型，也可以用“，”间隔，表示允许上传多个文件类型。这里允许上传文件类型为txt、xml格式的文件。如果读者不知道各个文件类型的定义，可在自己的JBoss安装目录中的server\default\deploy\jboss-web.deployer\conf\下的web.xml文件中找到（搜索<mime-mapping>即可）。
　　注意：如果显示配置Struts2自己的缺省拦截器一定要写在“defaultStack”前，否则“fileUpload”拦截器不会执行拦截。因为Struts2中如果某个拦截器执行拦截时候发现自己已经执行过，第二个乃至之后同名的拦截器都不会执行。这里因为“defaultStack”拦截器栈中包含了“fileUpload”拦截器，而“fileUpload”拦截器已经执行拦截了，则不会再执行拦截。如果把“defaultStack”拦截器栈放在“fileUpload”拦截器前配置，则只执行“defaultStack”拦截器栈中的“fileUpload”拦截器，这里是没有定义“allowedTypes”的，Struts2缺省默认的是支持所有文件类型。因此它会支持所有文件类型的文件上传。因此再设定“allowedTypes”就没有任何意义了。

4. 下载文件：运行http://localhost:18080/struts2/jsp/result.jsp
    <result name="success" type="stream">
		<param name="contentType">text/plain</param>
		<param name="contentDisposition">
			attachment;filename="${downloadChineseFileName}"
		</param>
		<param name="inputName">downloadFile</param>
	</result>
	在<result>标签中定义了type属性，值为“stream”。如果是下载文件功能开发，一定要设置type属性，而且值为“stream”。这是因为在Struts2自带的xml配置文件为struts-default.xml中有关于“stream”的result返回类型的定义，代码如下：<result-type name="stream" class="org.apache.struts2.dispatcher.StreamResult"/>
    这里Struts2定义了result返回类型为“stream”，这个result类型主要是处理文件的输入和输出流时候需要使用的。因为下载文件就是把文件转换成输入输出流，将其从一个文件路径放到另外一个文件路径中去。所以肯定要设置这个result类型的。
    “contentType”、“contentDisposition”、“inputName”都是这个result的属性。“contentType”就是文件类型。
	“contentDisposition”是指定下载文件处理方式。特别指出如果“contentDisposition”定义的值把前面的“attachment”去掉，则下载方式不是以附件方式下载，如果单击“下载”链接，则会把下载文件的内容显示在浏览器中。这里有个“${downloadChineseFileName}”，这就是在DownLoadAction中定义getDownloadChineseFileName方法的目的，${downloadChineseFileName}是OGNL的表达式，它显示了“downloadChineseFileName”变量的具体值，因为在DownLoadAction中定义getDownloadChineseFileName方法，则把已经转换成符合需要字符编码集的下载文件名作为下载文件方式对话框中显示的名称，不会造成任何乱码问题。
	“inputName”是最关键的一个属性，也是一定要定义的属性，“inputName”参数中定义的值“downloadFile”就是DownLoadAction中getDownloadFile方法返回的文件流名字。在Struts2中Acion用前缀名为get的方法得到各种属性的值，这些属性有些是在Action中定义，有些就像本示例在配置文件中利用OGNL表达式或直接定义。

5. 输入校验
   (1) 对输入校验这方面采用的最基本方法是在每个Action里继承ActionSupport类，并且重写它的输入校验方法validate()。struts.xml也定义了1个名字为“input”的result，它表明将所有输入失败的错误信息导航到一个特定页面。
       运行http://localhost:18080/struts2/jsp/register.jsp
	   
   (2) Struts2中除了validate方法之外它还有1种validateXXX方法针对Action中某一特定方法进行该方法的各种字段的输入校验。其中XXX就是该特定方法名。
       在RegisterAction定义了一个Register方法和validateRegister方法。当提交表单时，指定运行Register()方法时(action="Register!Register.action"),validateRegister方法就会被执行。
       注意：如果使用validateRegister方法，那最好不要再使用validate方法。validate方法会对所有的方法作校验，而validateRegister方法只对Register方法进行校验。因此两者不能重复使用，都使用会造成两个方法都进行了校验的结果。执行顺序是先validateRegister后validate。如果validateRegister方法有特殊的输入校验则就会被validate方法“覆盖”，因此达不到预期的输入校验目的。
	   运行http://localhost:18080/struts2/jsp/register.jsp
   
   (3) 使用配置文件来完成输入校验这种方式，首先在Action代码中去除所有validate和validateXXX方法的代码。然后在和Action类文件同一级目录下增加XXX-validation.xml配置文件。这里“XXX”是Action类文件名字，表示该XML文件中所有输入校验的规则定义和错误信息显示方式都只针对该Action有效。	   
	   运行http://localhost:18080/struts2/jsp/register2.jsp
	   
6. Struts2与Spring的集成
   (1)复制struts2-spring-plugin-x-x-x.jar和相应的spring.jar到/WEB-INF/lib目录下。
   (2)在struts.properties中设置struts.objectFactory = spring
      或者是在struts.xml文件中进行常量配置
		<struts>
			<constant name="struts.objectFactory" value="spring" />
		</struts>




##### Hibernate #####
  /hibernate/model目录: 存放POJO
  /hibernate/util目录: HibernateUtil类(获取hibernate session) 

1.Hibernate双向一对多关系例子
  /hibernate/model/User
  /hibernate/model/Address
  /config/hibernate/User.hbm.xml
  /config/hibernate/Address.hbm.xml
  hibernate.sample.HibernateSample1 利用hibernate的一对多关系进行数据库操作
  运行com.study.hibernate.sample.HibernateSample1.java
  
  一个用户有多个地址，在用户类User中包含地址类Address集合。
  在User.hbm.xml中定义Set:
  1) <set name="address"
          cascade="all-delete-orphan"
          inverse="false"
          lazy="true">
          <key column="user_id" />
          <one-to-many class="Address" />
     </set>
	设定inverse="false"，表示将one方(User)作为主动维护关系的类，所以当运行下列程序的时候
	User user = new User()...
	Address address = new Address();
	user.getAddress().add(address);
	...
	session.save(user);
	由于主控方是User，Address不知道User的user_id是多少，所以必須分別保存User和Address之后，再更新Address的user_id。
	后台会打印出如下的SQL脚本
	insert into User(id,name) values(?,?);
	insert into Address(id,name) values(?,?);
	update Address set user_id = ? where id = ?;
  
  2) <set name="address"
          cascade="all-delete-orphan"
          inverse="true"
          lazy="true">
          <key column="user_id" />
          <one-to-many class="Address" />
     </set>
	设定inverse="true"，表示将many方(Address)作为主动维护关系的类，所以当运行下列程序的时候
	User user = new User()...
	Address address = new Address();
	address.setUser(user); // 多方必须意识到单方的存在
	user.getAddress().add(address);
	...
	session.save(user);
	由于主控方是Address
	后台会打印出如下的SQL脚本
	insert into User(id,name) values(?,?);
	insert into Address(id,name,user_id) values(?,?,?);



##### Spring #####

配置文件: applicationContext.xml在web.xml中定义加载，并import以下配置文件applicationContext-spring-aopsample.xml(spring aop例子),applicationContext-spring-sample.xml(spring例子)
          applicationContext-struts-action.xml文件定义了struts action的配置，该文件由struts-config.xml加载


1.AOP Sample:
  /spring/aop目录中存放着简单的aop的例子
  /spring/aop/advice:几种声明通知 BeforeAdvice(前置通知),AfterAdvice(后通知), ArouncdAdvice(环绕通知), ThrowsAdvice(throw处理)
  在applicationContext中配置通知，并设定通知指向的Service(spring.aop.service.AdviceService)
  运行com.study.spring.aop.AdviceTest可以完成三种通知的测试


##### Spring事务控制说明 #####
	我们有A和B两个方法
	methodA
	{   
		……   
		methodB();   
		……   
	}   
     
	methodB
	{   
   ……   
	}
	
	Spring事务声明:
	(1)PROPAGATION_REQUIRED:如果存在一个事务，则支持当前事务。如果没有事务则开启一个新的事务。
													在调用methodB时，没有一个存在的事务，所以获得一个新的连接，开启了一个新的事务。 
													调用MethodA时，环境中没有事务，所以开启一个新的事务，当在MethodA中调用MethodB时，环境中已经有了一个事务，所以methodB就加入当前事务。
													
	(2)PROPAGATION_SUPPORTS:如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行。
													单纯的调用methodB时，methodB方法是非事务的执行的。 
													当调用methdA时,methodB则加入了methodA的事务中,事务地执行。
													
	(3)PROPAGATION_REQUIRES_NEW:总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起。
															当单独调用methodB时，相当于把methodb声明为REQUIRED。开启一个新的事务，事务地执行。
															调用methodA时会开启一个新的事务ts1，而调用methodB时会再次开启一个事务ts2。ts1称为外层事务，ts2称为内层事务。
															ts2是否成功并不依赖于ts1。如果methodA方法在调用methodB方法后的doSomeThingB方法失败了，而methodB方法所做的结果依然被提交。而除了methodB之外的其它代码导致的结果却被回滚了。 
															使用PROPAGATION_REQUIRES_NEW,需要使用JtaTransactionManager作为事务管理器。
	(4)PROPAGATION_NOT_SUPPORTED:总是非事务地执行，并挂起任何存在的事务。
	(5)PROPAGATION_NEVER:总是非事务地执行，如果存在一个活动事务，则抛出异常
	(6)PROPAGATION_SUPPORTS:如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行。
	(7)PROPAGATION_NESTED:如果一个活动的事务存在，则运行在一个嵌套的事务中. 如果没有活动事务, 则按TransactionDefinition.PROPAGATION_REQUIRED 属性执行 
	
	PROPAGATION_NESTED 与PROPAGATION_REQUIRES_NEW的区别:它们非常类似,都像一个嵌套事务，如果不存在一个活动的事务，都会开启一个新的事务。使用PROPAGATION_REQUIRES_NEW时，内层事务与外层事务就像两个独立的事务一样，一旦内层事务进行了提交后，外层事务不能对其进行回滚。两个事务互不影响。两个事务不是一个真正的嵌套事务。同时它需要JTA事务管理器的支持。 
使用PROPAGATION_NESTED时，外层事务的回滚可以引起内层事务的回滚。而内层事务的异常并不会导致外层事务的回滚，它是一个真正的嵌套事务。DataSourceTransactionManager使用savepoint支持PROPAGATION_NESTED时，需要JDBC 3.0以上驱动及1.4以上的JDK版本支持。其它的JTA TrasactionManager实现可能有不同的支持方式。
  
2.Sample:
	/spring/sample目录中存放着用spring来控制事务的例子
	/spring/sample/dao: 存放操作数据的Dao类，所有Dao都是继承BaseHibernateDaoImpl
	/spring/sample/exception: 存放着业务异常类 LogicException和全局环境变量 GlobalEnv
	/spring/sample/aop: 存放着AOP切片的Advice类
											ValidationAdvice:这是个AroundAdvice通知，监听TxUserService的方法；在ValidationAdvic的invoke方法中表明如果发现全局变量GlobalEnv是错误消息，则抛出LogicException
											LogInfoAdvice:这是个AfterThrow的通知，监听TxUserService的方法；当TxUserService中的方法抛出异常的时候，spring会调用LogInfoAdvice中的相对应的方法来完成处理。
	

	/spring/sample/service: 存放业务逻辑类service，在配置文件中对TxUserService进行了事务控制。
														<prop key="save*">PROPAGATION_REQUIRED,-LogicException</prop>
														如果service中的save方法发生了LogicException将会回滚所有事务
	
	/spring/sample/action: 存放TxSampleAction，这个Action用来调用TxUserService
	运行com.study.spring.sample.test.TxSampleTest可以看到TxSampleAction中不同的事务控制的情况
	
	TxSampleAction中描述4种情况
  situation 1:GlobalEnv在saveUserInfoAndExtension前设置error，则在执行saveUserInfoAndExtension后抛出异常，然后回滚数据库操作；而log(log)没有被执行。
  
  situation 2:GlobalEnv在saveUserInfoAndExtension后设置error，则在执行saveUserInfoAndExtension不会抛出异常；然而在log(log)时会抛出异常，并回滚log(log)数据库操作，不会回滚saveUserInfoAndExtension操作。

  situation 3:GlobalEnv在saveUserInfoAndExtension前设置error，则在执行saveUserInfoAndExtension后抛出异常，但是通过使用catch来捕获异常，并执行saveUserLog(userLog)，所以不会回滚log(log)操作，只是回滚了saveUserInfoAndExtension。
	
	还可以声明一个AfterThrow的Advice，对抛出异常的方法做监听，再完成一些额外的操作。
	注:<ref local="logAdvisor" /><ref local="validationAdvisor" />声明顺序是非常的关键的，如果logAdvice在前，虽然validationAdvice在检查完后抛出了异常，还是会执行logAdvice中的afterThrow方法
	   如果validationAdvisor在前，则当validationAdvice在检查完后抛出了异常后，不会执行logAdvice的方法了，因为这个异常已经被认为不是service抛出的了，所以logAdvice不会再捕获了。

	   

##### GWT #####	   

1. HelloWorld Sample: 在yeep_gwt\source\com\yeep\gwt\study\sample\helloWorld\ 目录下，本示例运用了i18n、以及 button和menu的简单应用

2. WidgetSample : 在yeep_gwt\source\com\yeep\gwt\study\sample\widgetSample\ 目录下，本示例运用了 多种widget component的使用

   (1) Button:  我们可以生成一个 ClickListener 并实现 public void onClick(Widget sender) 方法来响应一个button的事件
   
   (2) Hyperlinks: 每一个Hyperlinks组件，都需要实现HistoryListener接口，实现 onHistoryChanged(String historyToken) 方法来响应事件，并且在 *.Html 文件中加上 <iframe id="__gwt_historyFrame" style="width:0;height:0;border:0"></iframe> 来支持。 

   (3) Menu:  MenuBar、MenuItem 我们可以实现一个Command类，并将MenuItem和Command绑定
   
   (4) HTML:  可以创建HTML("...") 对象，来实现HTML代码
   
   (5) Tree:  可以对一个Tree对象添加 TreeListener 监听，并实现两个方法 onTreeItemSelected(TreeItem item) --- 点中某个Item时触发、onTreeItemStateChanged(TreeItem item) --- 当某个Item的状态发生改变时触发	   

3. rpcSample : 在study_gwt\source\com\yeep\gwt\study\sample\rpcSample\ 目录下，本示例运用了2种rpc的调用   
   ( http://localhost:18080/yeep/gwt/com.yeep.gwt.study.sample.rpcSample.RpcSample/RpcSample.html)     
   (1) 在hosted mode下的rpc调用
   (2) 利用Spring提供的gwt-servlet.xml的配置，完成了GWT Service访问Spring Service  
	   
	   



#### Junit & Easy Mock ####
1.Easymock: com.yeep.study.junit包下，展示了用easymock对接口方法的测试用例


#### Cglib ####
cglib，全称是Code Generation Library，它可以用来动态继承Java类或者实现接口。
利用Enhancer生成一个原有类的子类，并且设置好callback到proxy， 则原有类的每个方法调用都会转为调用实现了MethodInterceptor接口的proxy的intercept() 函数：
	public Object intercept(Object o,Method method,Object[] args,MethodProxy proxy)
在intercept()函数里，你可以在执行Object result=proxy.invokeSuper(o,args);来执行原有函数，在执行前后加入自己的东西，改变它的参数值，类似AOP中的around advice。
可以运行 com.yeep.study.cglib.EnhancerSample



#### Java Core ####

1. 泛型: 在com/yeep/study/javacore/generics中的GenericsTest.java展现了泛型的5种应用

所谓范型是指类型参数化(parameterized types)。Java是一种强类型的语言, 在J2SE 1.4以及以前的版本中, 我们在定义一个Java类, 接口或者方法的时候, 必须指定变量的类型。
在声明范型类、接口或者函数时, 定义变量的时候不指定某些变量的具体类型, 而是用一个类型参数代替. 在使用这个类, 接口, 或者方法的时候, 这个类型参数由一个具体类型所代替。

1)简单的范型声明：

		List<Integer> integerList = new ArrayList<Integer>();//定义成只能存放Integer类型的列表
		integerList.add(new Integer(1));
		// integerList.add(new String("Another Element")); // 当试图存放String类型的变量时，会出现编译错误
		Integer integer = integerList.get(0); // 使用的时候不需要再做类型的转换。
		
2)泛型和子类：
		List<String> stringList = new ArrayList<String>();
		List<Object> objectList = stringList;//会产生编译错误
		当我们使用objectList指向stringList。我们通过objectList来访问一个String的list。我们可以插入任意对象进去。结果是stringlList中保存的不再是String。当我们试图从中取出元素的时候，会得到意外的结果。Java编译器会阻止这个错误。

		如果Foo是Bar的一个子类型(子类或者子接口)，而G是某种泛型声明，那么G<Foo>是G<Bar>的子类型并不成立。
		
3)泛型类：GenericsList在类定义的时候定义变量类型

4)通配符：使用？来表示所有的类型

		Collection<Object>表示只能用于Object类的Collection集合，而不能适用于Object的子类，参见2)范型和子类
		Collection<?> 表示适用于所有的类型。Collection<?>(发音为:"collection of unknown")
		Collection<? extends String> 表示适用所有String和String的子类
		
5)泛型方法： 方法的声明也可以被泛型化——就是说，带有一个或者多个类型参数。
						 泛型函数允许类型参数被用来表示方法的一个或多个参数之间的依赖关系，或者参数与其返回值的依赖关系。如果没有这样的依赖关系，不应该使用泛型方法。
						 
	泛型方法和通配符的对比：
			boolean containsAll(Collection<?> c); ---> <T> boolean containsAll(Collection<T> c);
    		boolean addAll(Collection<? extends E> c); ---> <T extends E> boolean addAll(Collection<T> c);

6)泛型中的上界下界
上界: 上界用extends关键字声明，表示参数化的类型可能是所指定的类型，或者是此类型的子类。参考 com.yeep.study.javacore.generics.UpperLowerBoundTest
eg: public void upperBound(List<? extends Date> list, Date date)   
    {   
		Date now = list.get(0);   
		System.out.println("now==>" + now);   
		//list.add(date); //这句话无法编译   
		list.add(null);//这句可以编译，因为null没有类型信息   
    }  


为什么会无法编译呢，实际调用时传入的list可能是java.util.Date的某个子类的参数化类型，
eg: public void testUpperBound()   
	{   
		List<Timestamp> list = new ArrayList<Timestamp>();   
		Date date = new Date();   
		upperBound(list,date);   
	}  

也就是说，现在upperBound方法中实际的list是List<Timestamp>，向它添加一个Date类型，肯定是不行的。相反，读取数据时，不管实际的list是什么类型，但可以知道它至少会返回一个Date类型，所以用foreach，get等没有问题。 在无法判定元素date的类型Date能否一定加入List<? extends Date>时，编译器无法通过。

那么如何解决呢，可以使用泛型方法，在泛型方法中保证了date的类型和list的泛型类型都是T，是一致的，所以可以通过编译。这里方法声明中的T作为一种参数化信息，会存储在java字节码中，T的实际类型由调用时的参数决定的
public <T extends Date> void upperBound2(List<T> list, T date)   
{   
    list.add(date);   
}  


下界：下界用super进行声明，表示参数化的类型可能是所指定的类型，或者是此类型的父类型，直至Object。参考 com.yeep.study.javacore.generics.UpperLowerBoundTest
eg:	public void lowerBound(List<? super Timestamp> list)   
	{   
		Timestamp now = new Timestamp(System.currentTimeMillis());   
		list.add(now);   
		//Timestamp time = list.get(0); //不能编译   
	}  



这又为什么不能通过编译呢，看看调用代码: 
eg:	public void testLowerBound()   
	{   	
		List<Date> list = new ArrayList<Date>();   
		list.add(new Date());   
		lowerBound(list);   
	}  

lowerBound方法中的List<? super Timestamp>表示这个list的参数类型可能是Timestamp或Timestamp的父类.
如后面测试代码里，实际传入的是一个List<Date>类型。向List<Date>中add一个Timestamp肯定是没有问题的，但list.get()方法返回的对象类型可能是Date甚至是Object，你不能说list.get(0)返回的就是一个Timestamp，这里是向下类型转换了，编译器无法处理，所以这里不能编译。用java泛型实现的擦拭法解释，编译后会是如下的伪代码： 
	public void lowerBound(List list)   
	{   
		Timestamp now = new Timestamp(System.currentTimeMillis());   
		list.add(now);   
		Timestamp time = (Timestamp)list.get(0); //  
	}

2. Annotation:在com/yeep/study/javacore/annotation中展现了Annotation的应用

Annotation提供一种机制，将程序的元素如:类，方法，属性，参数，本地变量，包和元数据联系起来。这样编译器可以将元数据存储在Class文件中。这样虚拟机和其它对象可以根据这些元数据来决定如何使用这些程序元素或改变它们的行为。
在J2SE5.0的java.lang包中预定义了三个annotation，Override、Deprecated和SuppressWarnings。



###### WebService ######
Web Service主要是为了使原来各孤立的站点之间的信息能够相互通信、共享而提出的一种接口。 
Web Service所使用的是Internet上统一、开放的标准，如HTTP、XML、SOAP（简单对象访问协议）、WSDL等，所以Web Service可以在任何支持这些标准的环境（Windows,Linux）中使用。
SOAP协议（Simple Object Access Protocal,简单对象访问协议）,它是一个用于分散和分布式环境下网络信息交换的基于XML的通讯协议。

1. 	Axis2 : 
	利用Axis2的API创建Web Service，创建一个服务分 4 个步骤 
		a.编写Service代码 
		b.用 service.xml 来解释这个服务 
		c.创建一个 *.aar 的服务部署包
          发布包的结构如下: ***.aar
							 |
							 |---- package
							 |  |     
							 |  |---- ***Service.java
							 |
							 |---- META-INF
								|
								|---- service.xml
						
		d.发布服务: 配置Axis-Servlet，将*.aar放在../WEB-INF/services/目录中

(1) HelloWorld: yeep_wx/com.yeep.study.webservice.axis2.helloWorld
	本例子展现了一个简单的WebService的应用，分别采用了2种的消息传递 RPCMessageReceiver和RawXMLINOutMessageReceiver。
    RawXMLINOutMessageReceiver的service的方法可以没有参数，只能接受OMElement类型的参数，返回也是OMElement类型。
	RPCMessageReceiver的参数可以是任意的JAVA类型，返回可以使任意的JAVA类型。RPCMessageReceiver负责OMEelment到JAVA类型或者JAVA类型到OMElement的转换。

	我们可以运行com.yeep.study.webservice.axis2.HelloWorldClient.java来访问Web Service，也可以使用URL: http://localhost:18080/yeep/services/helloWorld/hello1?username=Roger
    hello2使用了AXIOM(The Axis Object Model)来完成对象的传输

(2) AxiomSample: yeep_wx/com.yeep.study.webservice.axis2.axiomSample 
	本例子展现了Axis2中使用AXIOM构建服务的方式，通过使用 Streaming API for XML (StAX) Pull 解析器，AXIOM可以控制解析过程，以提供延迟构建支持。延迟构建是指 AXIOM 不完全构建对象模型，模型的其余部分基于用户的需求构建。
    我们可以运行com.yeep.study.webservice.axis2.AxiomSampleClient.java来访问Web Service
	
    callSample1: 展示了简单的解析AXIOM对象的过程，包括节点、属性等
	callSample2: 展示了用StAXOMBuilder和XMLStreamReader一同构建AXIOM的过程。
				 
				 典型的实现代码:
				 1.BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(“MyFilePath”))); 
				   产生一个原始的 xml 数据流
				 
				 2.XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(reader);
				   产生拉式 (pull)xml 数据流
				 
				 3.StAXOMBuilder builder = new StAXOMBuilder(OMAbstractFactory.getOMFactory(),parser); 
				   产生 StAXOMBuilder 对象 
				   
				 4.OMElement root = builder.getDocumentElement(); 
				   获取根节点对象
 
        
		
		
###### Swing ######
		
Component Sample
1. 	LabelIconSample: 展现了Label,Icon,ImageIcon的例子，可以运行com.yeep.study.swing.component.LabelIconSample

2. 	ButtonSample: 展现了Button,ToggleButton,CheckBox,RadioButton的例子，可以运行com.yeep.study.swing.component.ButtonSample	

3. 	ListSample:展现了JList,ComboBox的例子，可以运行com.yeep.study.swing.component.ListSample

4. 	RootPaneSample: 展现了RootPane容器的例子，可以运行com.yeep.study.swing.component.RootPaneSample
                    Swing的顶层容器(JFrame,JWindow,JApplet)都包含有一个JRootPane，该JRootPane是一切Swing组件起点。
					
					JRootpane 由一个 glassPane 和一个可选的 menuBar 以及一个 contentPane 组成。（JLayeredPane 负责管理 menuBar 和 contentPane。）glassPane 位于所有窗格之上，以便能够截取鼠标移动。由于 glassPane（与 contentPane 类似）可以是一个任意的组件，也可以设置 glassPane 来进行绘制。这样 glassPane 上的线条和图像可涵盖其下的窗体，不受其边界的限制。
					GlassPane和JLayeredPane都是充满JRootPane的。GlassPane缺省情况下是不可见的，因此我们看到都是JLayeredPane。
					
					JLayeredPane直接包含有ContentPane组件。应用程序如果定了MenuBar，JLayeredPane还包含MenuBar。注意JLayeredPane本身没有布局管理器，它对组件的布局是由它的父容器JRootPane的布局管理器RootLayout来完成的。 
					JLayeredPane 为 JFC/Swing 容器添加了深度，允许组件在需要时互相重叠。Integer 对象指定容器中每个组件的深度，其中编号较高的组件位于其他组件之上。
						DEFAULT_LAYER 大多数组件位于的标准层。这是最底层。 
						PALETTE_LAYER	调色板层位于默认层之上。它们对于浮动工具栏和调色板很有用，因此可以位于其他组件之上。 
						MODAL_LAYER	该层用于模式对话框。它们将出现在容器中所有工具栏、调色板或标准组件的上面。 
						POPUP_LAYER	弹出层显示在对话框的上面。这样，与组合框、工具提示和其他帮助文本关联的弹出式窗口将出现在组件、调色板或生成它们的对话框之上。 
						DRAG_LAYER	拖动一个组件时，将该组件重分配到拖动层可确保将其定位在容器中的其他所有组件之上。完成拖动后，可将该组件重分配到其正常层。 
					可以使用 JLayeredPane 的方法 moveToFront(Component)、moveToBack(Component) 和 setPosition 在组件所在层中对其进行重定位。还可以使用 setLayer 方法更改该组件的当前层。 

	
					JFrame(BorderLayout)
							|
							|
					JRootPane(RootLayout)	
							
					|-----------------|
					|				  |	
					|				  |
				GlassPane		JLayeredPane
									  |
									  |
							   |-------------|	  
							   |             |
							MenuBar       ContentPane (BorderLayout)
							                 |
											 |
										Application Components	 
				
5.	InternalFrameSample: 展现了InternalFrame容器的例子，可以运行com.yeep.study.swing.component.InternalFrameSample
						 JInternalFrame的使用跟JFrame几乎一样，可以最大化、最小化、关闭窗口、加入菜单等功能;唯一不同的是JinternalFrame是lightweight component ,也就是说JInternalFrame不能单独出现，必须依附在最上层组件上。
						 Swing提供两种分层面板：JlayeredPane和JDesktopPane。 JDesktopPane是JLayeredPane的子类，专门为容纳内部框架（JInternalFrame）而设置。

6.	DialogSample : 展现了JDialog的例子，可以运行com.yeep.study.swing.component.DialogSample
				   JOptionPane是一个Dialog的工具类，它实现了一个Dialog的模板，包括了图标、消息、输入、按钮
				   
7.	SpecialPanelSample : 展现了一些特殊panel的例子，可以运行com.yeep.study.swing.component.SpecialPanelSample	
						 SplitPanel、ScrollPanel和TabPanel.
						 ScrollPanel由Viewport,Row header,Column header,Vertical scrollbar,Horizontal scrollbar,Four corners (upper left, upper right, lower left, and lower right) 组成

8.	MenuSample: 展现了菜单的例子，可以运行com.yeep.study.swing.component.MenuSample				   
				   
9.	ToolBarSample: 展现了工具栏的例子，可以运行com.yeep.study.swing.component.ToolBarSample		


###### JNI ######
1. JIntellitype : 本例用JIntellitype jar演示了如果监听后台键盘事件的操作 
                  可以运行 com.yeep.study.jni.JIntellitype.JIntellitypeTest			   
				   
				   
###### SWT/JFace ######				   
-Djava.library.path=D:\Work\yeep\Study\lib\swt				   
				   


######  XML 学习 #######
1. XSLT 将 XML 转换为 XHTML: 查看CDCatalog.xml与CDCatalog.xsl
  向 XML 文档（"查看com\yeep\study\xml\xslt\CDCatalog.xml"）添加 XSL 样式表引用 <?xml-stylesheet type="text/xsl" href="CDCatalog.xsl"?>
  如果使用的浏览器兼容 XSLT，就可以看到转换完的 XHTML

2. 浏览器解析XML。com\yeep\study\xml\parser\XmlStringParserSample.html展现了用浏览器来解析XML字符串的例子
                  com\yeep\study\xml\parser\XmlFileParserSample1.html则展现了用浏览器来解析XML文件的例子(使用浏览器的XMLDOM)
				  com\yeep\study\xml\parser\XmlFileParserSample2.html则展现了用浏览器来解析XML文件的例子(使用浏览器的XmlHttpRequest)
 
  
######  EJB3 #######  
1. 安装GlassFish 2.1: 
   (1) 安装JDK 1.5 或 1.6
   (2) 在命令行窗口输入命令: java -Xmx256 -jar glassfish-installer-*****.jar
   (3) 在安装目录下用ant来初始化glassfish的设置: .\lib\ant\bin\ant -f setup.xml
       我们也可以自由修改setup.xml中的初始配置
   (4) 在系统环境变量中添加 GLASSFISH_HOME
   (5) 在命令行窗口中用以下命令启动和停止服务器: asadmin start-domain domain1
                                                 asadmin stop-domain domain1
   (6) 访问http://localhost:4848进入console
   (7) 在应用程序的CLASSPATH中添加appserv-deployment-client.jar、appserv-ext.jar、jmxremote_optional.jar、appserv-rt.jar
   
2. Session Bean : Session Bean是实现业务逻辑的类，可以分为有状态和无状态两种。有状态的Bean可以维护会话状态，意味着EJB容器要为每个用户创建一个Bean的实例；而无状态Bean不需要维护会话状态，这时一个bean的实例可以为多个用户服务。
   一个Session Bean需要定义接口(远程或者本地)和Bean class:
   (1) 远程接口(Remote Interface): 定义了Session bean的业务方法，这些方法可以被来自EJB容器以外的应用访问。
   (2) 本地接口(Local Interface): 定义了Session Bean的业务方法，这些方法只能被同处于EJB容器内的应用访问。用Local接口可以允许Bean直接在内存交互，没有分布式协议的开销。
   (3) Bean类(Bean class): bean class包含了业务逻辑，它必须具备一个远程或本地接口

3.Stateless Session Bean ---
3.1 只实现Remote Interface的无状态Session Bean: HelloWorld是一个只实现了Remote接口的EJB
    (1) 定义一个普通接口(com.yeep.study.ejb3.helloWorld.HelloWorld.java)
    (2) 编写Bean class (com.yeep.study.ejb3.helloWorld.impl.HelloWorldBean.java)
        Bean类上有两个注释@Stateless和@Remote，
	  @Stateless是指明这是一个无状态会话Bean。@Stateless的name()属性是指EJB的名字，该名称在EJB的jar包中是全局唯一的。mappedName()属性是指Bean的全局JNDI名称，这个属性在weblogic、sun服务器和glassfish有效
	  
	  @Remote指定这个Bean的remote接口。Bean类可以有多个remote接口。
    (3) 打包EJB，不管用工具还是ANT打包，一个EJB打包后的应该具有以下目录结构：
        EJB应用根目录
	     |
	     |---- **/*.class
	     |
	     |---- META-INF
	             |
			     |----MANIFEST.MF
   
    (4) 调用EJB，我们需要知道EJB的JNDI，然后通过上下文获取EJB
        在com.yeep.study.ejb3.helloWorld.Test.java 中可以看到我们通过2种方式获取JNDI，一种用Properties在程序中设置，一种是在JNDI.properties文件中设置。
      也可以访问http://localhost.../study/jsp/study/ejb/helloWorld/HelloWorld.jsp
	  HelloWorld这个EJB定义了Remote接口，所以不论study.war和Test类是否在同一个Glassfish服务器，程序和页面都能显示正常信息。
	  
3.2. 只实现Local接口的无状态Session Bean: LocalSessionBean
     可以通过http://localhost.../study/jsp/study/ejb/localSessionBean/LocalSessionBean.jsp来访问
   
3.3 同时实现了远程与本地接口的Session Bean :　LocalRemoteSessionBean
    可以通过http://localhost.../study/jsp/study/ejb/localRemoteSessionBean/LocalRemoteSessionBean.jsp来访问
    Stateless Session Bean一旦被实例化后，就会被加入实例池，可以被各个用户使用，如果它拥有自己的属性(例如本例的 count属性)会受到所有用户操作的累加影响。 
	
3.4 EJB的实例管理机制: EJB提供了两种管理大量bean实例的机制：实例池化(instance pooling)和激活(activation)
    Stateless Session Bean会被实例化在实例吃中，当应用需要使用Bean时，容器会从实例池中获取一个实例，使用完毕后再放入池中
    stateful session bean会在不同的方法调用之间维护会话状态，它使用激活而不是实例池来降低资源的消    耗。当EJB服务器需要节省资源时，收回stateful session bean，释放它所占有的内在资源，并将其所保    持的会话状态序列化到辅助存储器中，如果客户端对该EJB对象再次发出请求，EJB容器会重新实例化一个stateful session bean，并从辅助存储器中将之前的状态恢复。
	
3.5 stateless session bean存在以下三种状态
    无状态(No state)：尚未被初始化
    池状态(Pooled state)：已经被容器初绐化
    就绪状态(Ready state)：已经与一个EJB请求关联，做好响应方法调用的准备



###### Ant ######
1. 自定义Ant任务: com.yeep.study.ant.Getfilelist.java 展示了自定义Ant任务，可以运行build-core.xml中的test-custom-ant-task任务来得到运行结果，可以看到如果解析文件并将文件内容循环显示。




###### MySQL ######
1. 中文问题
   1)修改my.ini
   
   [mysql]
   default-character-set=utf8 -------->改成utf8

   [mysqld]
   default-character-set=utf8 -------->改成utf8

   2)修改Data目录下数据库的db.opt文件
   default-character-set=utf8 -------->改成utf8
   default-collation=utf8_bin -------->改成utf8

   3)重新创建所有的数据表或者修改创建表的语句, 保证数据表的默认字符集改为utf8
   
     create table XXXX 
	 (      
      .....
	 ) engine=myisam default charset=utf8; 



   
###### Demo ######
1. Shudu: 数独的解法，可以使用http://localhost:18080/yeep/gwt/com.yeep.gwt.app.shudu.Shudu/Shudu.html访问
   业务代码存放在study_core\com.yeep.app.shudu
   页面代码使用GWT作为展现方式，存放在yeep_gwt\com.yeep.gwt.app.shudu

2. 计数小程序: 给定一个十进制数N，写下从1开始，到N的所有整数，然后数一下其中出现的所有"1"的个数。
   (com.study.app.demo.CountNumber)   

