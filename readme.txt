##########################
######## ��Ŀ˵�� ########
##########################

1.����Ŀ�����ĸ���ģ�� yeep_database, yeep_core, yeep_war��yeep_gwt

  yeep_databaseģ���а����ű���Ŀ���õ������ݿ������sql�ļ�
  
  yeep_coreģ���Ǳ���Ŀ�ĺ���ģ�飬�������������ļ���hibernate�����ļ���Spring�����ļ�
  
  yeep_warģ���Ǳ���Ŀ��WebApplicationģ�飬���������õ���ҳ���ļ�(jsp,css,js), �Լ�web.xml�����ļ�
  
  yeep_gwtģ�������gwt��Ӧ��
  
  
2.����Ŀ�Ĵ���ͷ���������Ant��ʵ�֣�����Ant�����˵���������ģ��ı��롢����ͷ���  


#########################
##### Ant ����˵�� ######
#########################

1.����Ŀ��Ant��������:

  ��Ŀ¼��   build-shared.xml,build.xml,build.properties
  database:  build-database.xml,database.properties
  studyCore: build-core.xml
  study_war: build-war.xml
  
  �����ļ��İ�����ϵ:build-shared.xml�����˹��õĶ���,��Ŀ¼��build.xml�ļ�������������Ŀ¼��build�ļ����������ļ�������ģ��ĸ��������������ļ����Э������������Ĺ�ϵ�������Ŀ�Ĵ���ͷ�����


2.�����ļ�˵��:

  ��Ŀ¼��build.xml ��������Ҫ���� build-war 
  			build-war �����Ŀ�Ĵ���ͷ�������
  			          (1)ִ�� build-core.xml�е�all����
  			          (2)ִ�� build-war.xml�е�all����
  			          (3)yeep_core��build/classes�еı�����ɵ���copy��study-war�е�./WEB-INF/classesĿ¼
  
  database:  build-database.xml ����2����Ҫ���� db-create �� db_drop
			 
			 db-create �������ݿ�
			 db_drop ɾ�����ݿ�
			 
			 ���ǿ��Ե���������2��������ʵ�����ݿ�Ĵ�����ɾ��,ע:build-database.xml���õ���database.properties�е����ݿ�����
  
  core: build-core.xml ������3����Ҫ���� all��clean-directory��create-directory��compile��config
			
			all	������Ŀ¼�ʹ���Ŀ¼���ֱ�ִ��clean-directory��create-directory��compile��config����
			clean-directory ���Ŀ¼ (./build/*)
			create-directory ����Ŀ¼ (./build/*)
			compile ����source�е��������ļ���������./build/classesĿ¼
			config ��config�е������ļ�copy��./build/configĿ¼
			 
  war: build-war.xml ������3����Ҫ���� all��clean-directory �� create-directory
			
			all	������Ŀ¼�ʹ���Ŀ¼�����Ȼ�ִ��clean-directory��Ȼ��ִ��create-directory
			clean-directory ���Ŀ¼ (./WEB-INF/classes)
			create-directory ����Ŀ¼ (./WEB-INF/classes)
  
  gwt:build-gwt.xml ������2����Ҫ���� compile, compile-client
		   
		   compile ��������yeep_gwt�Ĵ���
		   compile-client �������д��룬����copy��war����ӦĿ¼��
  
  

#########################
####### ����˵�� ########
#########################

##### Ajax #####
1.Ajax ���� : /jsp/ajaxĿ¼�а����˼򵥵�ajax��ʾ��
  ����: http://localhost:18080/yeep/jsp/study/ajax/*.jsp



##### JSTl #####
1.JSTl ����: jsp/jstlĿ¼�°�����jstlSample.jsp(jstl tag����)
  ����: http://localhost:18080/yeep/jsp/study/jstl/*.jsp


##### Javascript #####

1.Prototype
jsp/javascript/prototypeĿ¼�����prototype.js������
����: http://../yeep/jsp/study/javascript/prototype/*.jsp

(1)dollarSample.jsp: $( ),$F( ),$A( ),$H( ),$R( ) ������ʹ��

	$()������document.getElementById()������һ�������ļ�д���������DOM����һ��������������ز��������id���Ǹ�Ԫ�ء�����Դ�����id��Ϊ����Ȼ�� $() ����һ����������Ҫ���Ԫ�ص�һ�� Array ����
	$F()��������һ���ǳ��ܻ�ӭ�ļ�д�������Է����κ�������ؼ���ֵ�����ı���������� ����������Դ���Ԫ�ص�id����Ԫ���Լ���
	$A()�����ѽ��յ��Ĳ���ת����һ��Array��������������϶�Array�����չ�����Ժ����׵�ת�����߸���������о��б�Array����
	$H()�����Ѷ���ת���ɿ�ö�ٵ�ò����������Hash����
	$R()������new ObjectRange(lowerBound, upperBound, excludeBounds)��һ���򵥿�ݵ�ʹ�÷�ʽ��
	Try.these() ����ʹ��ʵ�ֵ�������ò�ͬ�ķ���ֱ�����е�һ���ɹ����������������÷ǳ����ף� ����һϵ�еķ�����Ϊ�������Ұ�˳���һ��һ����ִ����Щ����ֱ�����е�һ���ɹ�ִ�У����سɹ�ִ�е��Ǹ������ķ���ֵ��	

(2)ajaxSample1_1.jsp:�򵥵�����prototype.js��Ajax��Ӧ
	
	URL:http://localhost:18080/study/jsp/javascript/prototype/sampleAjax1_2.jsp?username= ��������
	�� Ajax.Request����ͷ�����ͨ�Ų��ҵõ����XML�Ƿǳ��򵥵ģ�����{method: 'post', parameters: pars, onComplete: showResponse} ��ʾһ�������������ʵд��������ʾ�㴫������������һ����Ϊ method ֵΪ 'post'�����ԣ���һ��������Ϊ parameters ����HTTP����Ĳ�ѯ�ַ�������һ��onComplete ����/������������showResponse������һЩ���������Կ���������������涨������ã��� asynchronous������Ϊtrue �� false ������AJAX�Է������ĵ����Ƿ����첽�ģ�Ĭ��ֵ�� true���������������AJAX���õ�ѡ�
	
	�����ǵ������У��ڵ�һ������ͨ��HTTP GET���������Ǹ�url�������˱��� pars�����Ĳ�ѯ�ַ����� Ajax.Request ����������ɽ�����Ӧ��ʱ�򽫵���showResponse ������XMLHttpRequest��HTTP�����ڼ佫������������������ȱ�����Ϊ�ĸ���ͬ�׶Σ�Loading, Loaded, Interactive, �� Complete�������ʹ Ajax.Request �������κν׶ε����Զ��巽�� ��Complete ����õ�һ����������Զ���ķ���ֻ��Ҫ�򵥵��������ѡ������е���Ϊ onXXXXX ����/�������ṩ�Զ���ķ������� �������������е� onComplete ���㴫��ķ������ᱻ��һ���������ã���������� XMLHttpRequest �����Լ����㽫�����������ȥ�õ����ص����ݲ��һ��������������ε����е�HTTP�������� status ���ԡ����������������õ�ѡ�����������������ǿ�����onSuccess ѡ�����һ����������AJAX�����ִ�������ã� �෴�ģ�Ҳ������onFailureѡ�����һ�����������������˳��ִ���ʱ���á�����onXXXXX ѡ���ķ���һ�����������ڱ����õ�ʱ��Ҳ����һ������AJAX�����XMLHttpRequest����

	
	�����ķ���������һ�˷��ص���Ϣ�Ѿ���HTML�ˣ���ôʹ��Ajax.Updater ��������ӵ����ס�������ֻ���ṩ��һ��Ԫ����Ҫ��AJAX���󷵻ص�HTML���Ϳ����ˣ�

(3)otherSample.jsp:��ʾ���Զ���Class��Observer���÷�


2.Javascript����ʹ��
jsp/javascript/jsFunctionSample.jsp ʵ����javascript������ʹ��
(1)�����Ķ���,���������ַ���(������ʹ���кܴ������)��
		a.function add(x,y){return x+y;}
		b.var add = function(x,y){return x+y;}
		c.var add = new Function("x","y","return x+y;");
		d.var add =function a(x,y){return x+y;}

(2)�����Ĳ���:��һ���������ڣ���ʶ��arguments�����⺬��,���ǵ��ö����һ���������ԡ�
		arguments.length and arguments[index]�����ں����ڱ����ã��������㲻Ҫ�ں����ڸı�����(��Ȼ���Ա��޸�)��
		arguments���и����� callee.���õ�ǰ����ִ�еĺ�����
		
(3)����--��������:��javascript�У������������ַ��������֡�����һ������һ�����ݡ�
    var add=function(x,y){return x+y;};��ʵ���Ǻ����Ķ��嶼�ǰѺ�����ֵ�������������������Ը�ֵ�������������Ե��ɲ������ݡ�
		��ʵ���ǰѺ���������ȫ�ֱ����������ֶ��С���
    	var  MyLib =  {} ;
  		MyLib.fun1 = function ()  {} ;
  		MyLib.fun2 = function ()  {} ;
		�����ͻ���������������뷢�������ϵĳ�ͻ�ˡ�

(4)��������������:�ڱ����ﺯ���и�Ԥ������̣������������Ҳ�������������⺯�����岻ͬд�����Ҳ��ͬ��

		����fun1�ܱ����ã���fun2��fun3�����ܣ���ͬ�����д������ǲ�ͬ�� (fun1���������Ǳ�Ԥ�ȱ����ˣ����Կ�����fun1����ǰʹ����)
  	    fun1();
        fun2();
  	    fun3();

		function  fun1()  {} 
		var fun2 = function ()  {} ;
		var fun3 = new Function( "" );


3.Javascript����ʹ��
(1)jsp/javascript/jsObjectSample1.jsp ʵ���� javascript��������ķ�ʽ
  (a)var obj = new Object();
      
  (b)var obj =
     {
     	name:'xxx',
		age:yyy,
		desc:function(){...}
     }

  (c)function CustomerObject(){};
     var obj = new CustomerObject();
	 new Object(),new function()ͬ�ȼ�;new function()�̳���Object��prototype,Ҳ��̳� function��prototype


(2)jsp/javascript/jsObjectSample2.jsp ʵ���� javascript ʹ�ö������Եķ�ʽ
	������Կ����Ƿ�����Ҳ����ָ�ֶΡ���һ���Զ��塰�ࡱ�������м����ط����Զ������ԡ�
   (a)��������ֱ�Ӷ��塣��Person.name�����ⶨ���൱�����������ԡ���̬�ģ����ʵ�ʱ�������Person.name�����ʣ�������new Person().name���ʣ�Ҳ���ʲ�����
   (b)���캯����this.�С�������new function()ʱ����Щ���Ծ��������ֶ�������ԡ���new Person().����  �����ʡ�
   (c)�����ö����Ժ󣬸������������ԡ��͹��캯���е�����ʹ�����ơ�
   (d)��������prototype��
   (e)�����Object��prototype��


(3)jsp/javascript/jsObjectSample3.jspʵ������javascript�̳е����ַ�ʽ:
   (a)��ĳ���ඨ�������ķ���, ͨ���ڸ��������ຯ�����ڲ����ó���Ĺ��캯��
   (b)����һ���������, Ȼ���丳ֵ���������� prototype ����, �Դ˷�ʽ����������ļ̳�

4. javascript��������ʽ
   jsp/javascript/regexp/regularExpressionSample.jsp ʵ������javascript�������У���������ʽ��Ӧ��

5. Javascript DOM: /jsp/javascript/domĿ¼�а����˼򵥵�dom��ʾ��
   
	ҳ�������Ԫ����DOM�б������Node�����ǿ��Ը���Node.nodeType����������:
		element node --> nodeType = 1, eg. <html>,<body>, etc.
		text node    --> nodeType = 2, eg. <p>text content</p>(<p></p>�ڵ��ڵ��ı�����)
		���Խڵ�     --> nodeType = 3, eg. <p title="Title1"> (title="Title1"����һ�����Խڵ�)
		
	DOM�ṩ��getElementById(id),getElementByTagName(name),getElementByName(name),getAttribute(),setAttribute��������ɶ�ҳ��Ԫ�صĲ���

(1)domSample1_1.jsp չʾ�˱���HTML�е�ȫ��Ԫ�أ�����child����ȡDocument������Ӷ���
(2)domSample2_1.jsp չʾ�˴�����ɾ��Table��Ԫ�ؽڵ�Ĳ���
(3)domSample3_1.jsp	չʾ��innerHTML,outterHTML��innerText���÷�   
(4)domSample4_1.jsp	չʾ��Javascritp��ȡXML���� 	




##### Struts1 ##### 
ע��:���������ĺ����·��������, ����Struts�����Ӷ�ʹ��http://../yeep/strutsSample.do?forward=*** ���������е�����

�����ļ�:struts-config.xml��web.xml����,��������spring���������е�action,���Բ���plug-in�ķ�ʽ������applicationContext-struts-action.xml

(1)DispatchAction:����������Struts��DispatchAction�ķ������䣬ʹ��http://.../yeep/strutsSample.do?forward=dispatchTest������
      ��url��method�ķ���û��ָ��������£���Ĭ�ϵ���unspecified��������struts-config.xml�ж�����com.study.struts.action.DispatchActionTestAction����url�п���ͨ�� http://.../study/dispatchActionTest.do?method=yyy������
	
(2)Struts and Ajax:����չʾ��Ajax��Struts�Ļ�����ã�����ͨ��http://.../yeep/strutsSample.do?forward=ajaxSample������
   ��/jsp/study/struts1/strutsAjaxSample.jsp������prototype.js�����������˵���������StrutsAjaxSampleAction�����ظ�ҳ���ѯ���Ľ��


(3)Struts DynaForm:����չʾ����Struts��DynaForm��ʵ�ֶ�̬form��ʹ��,����ͨ��http://.../yeep/strutsSample.do?forward=dynaFormTest������



###################
##### Struts2 ##### 
###################
1. Struts2 ���
   Struts2���ռ���ϸ�ڻ��֣���Ҫ��Ϊ���¼��顣
   ��ǩ�⣺����ͼ��������Щ��ǩ��ʵ����ҳ�ϸ��ָ�ʽ����ʾ��
   ��������HTTP�����ڽ������������ִ��ǰ��ִ���������еĹ��ܡ�
   FilterDispatcher��Action������HTTP���󣬸���Action��ActionMapper��������Action��Щ������
   Struts2�����ļ����������ת�����̣�ÿ��Action��Ĵ���ͽ��������ε�������Ӧ��ʾ���涼�������塣
   OGNL������ת�����ڱ�ʾ���潫�������ݵ�Java�����������ת������ʾ������ҳ���������ݸ�ʽ��
   Struts2У����򣺶�����������ϸ��壬��֤û���������ݺͲ�������Ŀ��������ݡ�
   ���ʻ��ͱ��ػ�������ַ������ת������Web��Ŀ��ʾ�������԰汾��

2. ������ Interceptor:��struts.xml�ļ��п������������Զ����������
   ����:<interceptors>
			<interceptor name="generalInterceptorExample"
				class="com.yeep.struts2Study.interceptor.GeneralInterceptorExample">
				<param name="parameter">testParameter</param>
			</interceptor>
			<interceptor-stack name="sampleStack">
				<interceptor-ref name="generalInterceptorExample"></interceptor-ref>
				<interceptor-ref name="defaultStack"></interceptor-ref>
			</interceptor-stack>
		</interceptors>
   (1)��xml�����ļ���������������������ջ�����ԡ�<interceptors>����ͷ���ԡ�</interceptors>����β��
   (2)�����������ĸ�ʽ�����������ʾ�ԡ�<interceptor/>����ʽ��ʾ��������������name�����������֣���һ���Ƕ�Ӧ����·��, Ҳ��������Զ���Ĳ���<param/>
   (3)������ջ�ĸ�ʽ���ԡ�<interceptor-stack >����ͷ���ԡ�</interceptor-stack>����β����������name��������ջ���֡��ڡ�<interceptor-stack >���͡�</interceptor-stack>��֮������������������������ʾ��ʽΪ��<interceptor-ref />��������name����Ҳ�����������֡�
      ע�⣺������ջ�в�������������������������������������������ջ�������ڡ�sampleStack�� ������ջ�о������ˡ�defaultStack��������ջ�������Ļ������õ���������ջ�е�������Ҳ�ᱻִ�С�
   
   ��Action������������������������:
    <action ...>
	    ...
		<interceptor-ref name="generalInterceptorExample">
			<param name="parameter">newTtestParameter</param>
		</interceptor-ref>
		<interceptor-ref name="defaultStack"></interceptor-ref>
	</action>
	��Action����ʾ�����á�generalInterceptorExample���͡�defaultStack����������������������ջ��
	
	<action ...>
	    ...
		<interceptor-ref name="sampleStack"></interceptor-ref>
	</action>
	��Action����ʾ�����á�sampleStack�������������ջ���ﵽ�͵�һ��������ͬ��Ч������Ϊ�ڶ��塰sampleStack����ʱ���Ѿ������ˡ�generalInterceptorExample���͡�defaultStack����
	ע�⣺�����<Action>�в����á�defaultStack��������ջ����Login.action����ʱ��ֻ��ִ�����õġ�generalInterceptorExample��������������ִ�С�defaultStack��������ջ�����ҡ�defaultStack����Struts2���õ�ȱʡ������ջ��
	      Struts2�涨�����<Action>��,������Ա�������Լ��������������������ջ������ʽ��struts.xml�����ļ������á�defaultStack��������ջ��������struts-default.xml�ж����������������ִ�м���ִ�С�defaultStack��������ջ����Ȼ�����<Action>�п�����Աû�������Լ��������������������ջ�����㲻��ʾ���á�defaultStack��������ջ����defaultStack��������ջ�ǻ�ִ�еġ�

3. �ϴ��ļ�: ����http://localhost:18080/struts2/jsp/upload.jsp
������ʵ������ָ���ϴ��ļ��ĸ�ʽ������ֻ�ϴ��ض����͵��ļ�������ֻ���ϴ��ı���xml�ļ�������struts.xml��Ҫ��ʾ���á�uploadFile����������
����������һ����Ϊ��allowedTypes���Ĳ�����������<param></param>֮������ļ����ͣ�Ҳ�����á������������ʾ�����ϴ�����ļ����͡����������ϴ��ļ�����Ϊtxt��xml��ʽ���ļ���������߲�֪�������ļ����͵Ķ��壬�����Լ���JBoss��װĿ¼�е�server\default\deploy\jboss-web.deployer\conf\�µ�web.xml�ļ����ҵ�������<mime-mapping>���ɣ���
����ע�⣺�����ʾ����Struts2�Լ���ȱʡ������һ��Ҫд�ڡ�defaultStack��ǰ������fileUpload������������ִ�����ء���ΪStruts2�����ĳ��������ִ������ʱ�����Լ��Ѿ�ִ�й����ڶ�������֮��ͬ����������������ִ�С�������Ϊ��defaultStack��������ջ�а����ˡ�fileUpload��������������fileUpload���������Ѿ�ִ�������ˣ��򲻻���ִ�����ء�����ѡ�defaultStack��������ջ���ڡ�fileUpload��������ǰ���ã���ִֻ�С�defaultStack��������ջ�еġ�fileUpload����������������û�ж��塰allowedTypes���ģ�Struts2ȱʡĬ�ϵ���֧�������ļ����͡��������֧�������ļ����͵��ļ��ϴ���������趨��allowedTypes����û���κ������ˡ�

4. �����ļ�������http://localhost:18080/struts2/jsp/result.jsp
    <result name="success" type="stream">
		<param name="contentType">text/plain</param>
		<param name="contentDisposition">
			attachment;filename="${downloadChineseFileName}"
		</param>
		<param name="inputName">downloadFile</param>
	</result>
	��<result>��ǩ�ж�����type���ԣ�ֵΪ��stream��������������ļ����ܿ�����һ��Ҫ����type���ԣ�����ֵΪ��stream����������Ϊ��Struts2�Դ���xml�����ļ�Ϊstruts-default.xml���й��ڡ�stream����result�������͵Ķ��壬�������£�<result-type name="stream" class="org.apache.struts2.dispatcher.StreamResult"/>
    ����Struts2������result��������Ϊ��stream�������result������Ҫ�Ǵ����ļ�������������ʱ����Ҫʹ�õġ���Ϊ�����ļ����ǰ��ļ�ת��������������������һ���ļ�·���ŵ�����һ���ļ�·����ȥ�����Կ϶�Ҫ�������result���͵ġ�
    ��contentType������contentDisposition������inputName���������result�����ԡ���contentType�������ļ����͡�
	��contentDisposition����ָ�������ļ�����ʽ���ر�ָ�������contentDisposition�������ֵ��ǰ��ġ�attachment��ȥ���������ط�ʽ�����Ը�����ʽ���أ�������������ء����ӣ����������ļ���������ʾ��������С������и���${downloadChineseFileName}�����������DownLoadAction�ж���getDownloadChineseFileName������Ŀ�ģ�${downloadChineseFileName}��OGNL�ı��ʽ������ʾ�ˡ�downloadChineseFileName�������ľ���ֵ����Ϊ��DownLoadAction�ж���getDownloadChineseFileName����������Ѿ�ת���ɷ�����Ҫ�ַ����뼯�������ļ�����Ϊ�����ļ���ʽ�Ի�������ʾ�����ƣ���������κ��������⡣
	��inputName������ؼ���һ�����ԣ�Ҳ��һ��Ҫ��������ԣ���inputName�������ж����ֵ��downloadFile������DownLoadAction��getDownloadFile�������ص��ļ������֡���Struts2��Acion��ǰ׺��Ϊget�ķ����õ��������Ե�ֵ����Щ������Щ����Action�ж��壬��Щ����ʾ���������ļ�������OGNL���ʽ��ֱ�Ӷ��塣

5. ����У��
   (1) ������У���ⷽ����õ��������������ÿ��Action��̳�ActionSupport�࣬������д��������У�鷽��validate()��struts.xmlҲ������1������Ϊ��input����result������������������ʧ�ܵĴ�����Ϣ������һ���ض�ҳ�档
       ����http://localhost:18080/struts2/jsp/register.jsp
	   
   (2) Struts2�г���validate����֮��������1��validateXXX�������Action��ĳһ�ض��������и÷����ĸ����ֶε�����У�顣����XXX���Ǹ��ض���������
       ��RegisterAction������һ��Register������validateRegister���������ύ��ʱ��ָ������Register()����ʱ(action="Register!Register.action"),validateRegister�����ͻᱻִ�С�
       ע�⣺���ʹ��validateRegister����������ò�Ҫ��ʹ��validate������validate����������еķ�����У�飬��validateRegister����ֻ��Register��������У�顣������߲����ظ�ʹ�ã���ʹ�û��������������������У��Ľ����ִ��˳������validateRegister��validate�����validateRegister���������������У����ͻᱻvalidate���������ǡ�����˴ﲻ��Ԥ�ڵ�����У��Ŀ�ġ�
	   ����http://localhost:18080/struts2/jsp/register.jsp
   
   (3) ʹ�������ļ����������У�����ַ�ʽ��������Action������ȥ������validate��validateXXX�����Ĵ��롣Ȼ���ں�Action���ļ�ͬһ��Ŀ¼������XXX-validation.xml�����ļ������XXX����Action���ļ����֣���ʾ��XML�ļ�����������У��Ĺ�����ʹ�����Ϣ��ʾ��ʽ��ֻ��Ը�Action��Ч��	   
	   ����http://localhost:18080/struts2/jsp/register2.jsp
	   
6. Struts2��Spring�ļ���
   (1)����struts2-spring-plugin-x-x-x.jar����Ӧ��spring.jar��/WEB-INF/libĿ¼�¡�
   (2)��struts.properties������struts.objectFactory = spring
      ��������struts.xml�ļ��н��г�������
		<struts>
			<constant name="struts.objectFactory" value="spring" />
		</struts>




##### Hibernate #####
  /hibernate/modelĿ¼: ���POJO
  /hibernate/utilĿ¼: HibernateUtil��(��ȡhibernate session) 

1.Hibernate˫��һ�Զ��ϵ����
  /hibernate/model/User
  /hibernate/model/Address
  /config/hibernate/User.hbm.xml
  /config/hibernate/Address.hbm.xml
  hibernate.sample.HibernateSample1 ����hibernate��һ�Զ��ϵ�������ݿ����
  ����com.study.hibernate.sample.HibernateSample1.java
  
  һ���û��ж����ַ�����û���User�а�����ַ��Address���ϡ�
  ��User.hbm.xml�ж���Set:
  1) <set name="address"
          cascade="all-delete-orphan"
          inverse="false"
          lazy="true">
          <key column="user_id" />
          <one-to-many class="Address" />
     </set>
	�趨inverse="false"����ʾ��one��(User)��Ϊ����ά����ϵ���࣬���Ե��������г����ʱ��
	User user = new User()...
	Address address = new Address();
	user.getAddress().add(address);
	...
	session.save(user);
	�������ط���User��Address��֪��User��user_id�Ƕ��٣����Ա�횷քe����User��Address֮���ٸ���Address��user_id��
	��̨���ӡ�����µ�SQL�ű�
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
	�趨inverse="true"����ʾ��many��(Address)��Ϊ����ά����ϵ���࣬���Ե��������г����ʱ��
	User user = new User()...
	Address address = new Address();
	address.setUser(user); // �෽������ʶ�������Ĵ���
	user.getAddress().add(address);
	...
	session.save(user);
	�������ط���Address
	��̨���ӡ�����µ�SQL�ű�
	insert into User(id,name) values(?,?);
	insert into Address(id,name,user_id) values(?,?,?);



##### Spring #####

�����ļ�: applicationContext.xml��web.xml�ж�����أ���import���������ļ�applicationContext-spring-aopsample.xml(spring aop����),applicationContext-spring-sample.xml(spring����)
          applicationContext-struts-action.xml�ļ�������struts action�����ã����ļ���struts-config.xml����


1.AOP Sample:
  /spring/aopĿ¼�д���ż򵥵�aop������
  /spring/aop/advice:��������֪ͨ BeforeAdvice(ǰ��֪ͨ),AfterAdvice(��֪ͨ), ArouncdAdvice(����֪ͨ), ThrowsAdvice(throw����)
  ��applicationContext������֪ͨ�����趨ָ֪ͨ���Service(spring.aop.service.AdviceService)
  ����com.study.spring.aop.AdviceTest�����������֪ͨ�Ĳ���


##### Spring�������˵�� #####
	������A��B��������
	methodA
	{   
		����   
		methodB();   
		����   
	}   
     
	methodB
	{   
   ����   
	}
	
	Spring��������:
	(1)PROPAGATION_REQUIRED:�������һ��������֧�ֵ�ǰ�������û����������һ���µ�����
													�ڵ���methodBʱ��û��һ�����ڵ��������Ի��һ���µ����ӣ�������һ���µ����� 
													����MethodAʱ��������û���������Կ���һ���µ����񣬵���MethodA�е���MethodBʱ���������Ѿ�����һ����������methodB�ͼ��뵱ǰ����
													
	(2)PROPAGATION_SUPPORTS:�������һ������֧�ֵ�ǰ�������û��������������ִ�С�
													�����ĵ���methodBʱ��methodB�����Ƿ������ִ�еġ� 
													������methdAʱ,methodB�������methodA��������,�����ִ�С�
													
	(3)PROPAGATION_REQUIRES_NEW:���ǿ���һ���µ��������һ�������Ѿ����ڣ���������ڵ��������
															����������methodBʱ���൱�ڰ�methodb����ΪREQUIRED������һ���µ����������ִ�С�
															����methodAʱ�Ὺ��һ���µ�����ts1��������methodBʱ���ٴο���һ������ts2��ts1��Ϊ�������ts2��Ϊ�ڲ�����
															ts2�Ƿ�ɹ�����������ts1�����methodA�����ڵ���methodB�������doSomeThingB����ʧ���ˣ���methodB���������Ľ����Ȼ���ύ��������methodB֮����������뵼�µĽ��ȴ���ع��ˡ� 
															ʹ��PROPAGATION_REQUIRES_NEW,��Ҫʹ��JtaTransactionManager��Ϊ�����������
	(4)PROPAGATION_NOT_SUPPORTED:���Ƿ������ִ�У��������κδ��ڵ�����
	(5)PROPAGATION_NEVER:���Ƿ������ִ�У��������һ����������׳��쳣
	(6)PROPAGATION_SUPPORTS:�������һ������֧�ֵ�ǰ�������û��������������ִ�С�
	(7)PROPAGATION_NESTED:���һ�����������ڣ���������һ��Ƕ�׵�������. ���û�л����, ��TransactionDefinition.PROPAGATION_REQUIRED ����ִ�� 
	
	PROPAGATION_NESTED ��PROPAGATION_REQUIRES_NEW������:���Ƿǳ�����,����һ��Ƕ���������������һ��������񣬶��Ὺ��һ���µ�����ʹ��PROPAGATION_REQUIRES_NEWʱ���ڲ�������������������������������һ����һ���ڲ�����������ύ����������ܶ�����лع����������񻥲�Ӱ�졣����������һ��������Ƕ������ͬʱ����ҪJTA�����������֧�֡� 
ʹ��PROPAGATION_NESTEDʱ���������Ļع����������ڲ�����Ļع������ڲ�������쳣�����ᵼ���������Ļع�������һ��������Ƕ������DataSourceTransactionManagerʹ��savepoint֧��PROPAGATION_NESTEDʱ����ҪJDBC 3.0����������1.4���ϵ�JDK�汾֧�֡�������JTA TrasactionManagerʵ�ֿ����в�ͬ��֧�ַ�ʽ��
  
2.Sample:
	/spring/sampleĿ¼�д������spring���������������
	/spring/sample/dao: ��Ų������ݵ�Dao�࣬����Dao���Ǽ̳�BaseHibernateDaoImpl
	/spring/sample/exception: �����ҵ���쳣�� LogicException��ȫ�ֻ������� GlobalEnv
	/spring/sample/aop: �����AOP��Ƭ��Advice��
											ValidationAdvice:���Ǹ�AroundAdvice֪ͨ������TxUserService�ķ�������ValidationAdvic��invoke�����б����������ȫ�ֱ���GlobalEnv�Ǵ�����Ϣ�����׳�LogicException
											LogInfoAdvice:���Ǹ�AfterThrow��֪ͨ������TxUserService�ķ�������TxUserService�еķ����׳��쳣��ʱ��spring�����LogInfoAdvice�е����Ӧ�ķ�������ɴ���
	

	/spring/sample/service: ���ҵ���߼���service���������ļ��ж�TxUserService������������ơ�
														<prop key="save*">PROPAGATION_REQUIRED,-LogicException</prop>
														���service�е�save����������LogicException����ع���������
	
	/spring/sample/action: ���TxSampleAction�����Action��������TxUserService
	����com.study.spring.sample.test.TxSampleTest���Կ���TxSampleAction�в�ͬ��������Ƶ����
	
	TxSampleAction������4�����
  situation 1:GlobalEnv��saveUserInfoAndExtensionǰ����error������ִ��saveUserInfoAndExtension���׳��쳣��Ȼ��ع����ݿ��������log(log)û�б�ִ�С�
  
  situation 2:GlobalEnv��saveUserInfoAndExtension������error������ִ��saveUserInfoAndExtension�����׳��쳣��Ȼ����log(log)ʱ���׳��쳣�����ع�log(log)���ݿ����������ع�saveUserInfoAndExtension������

  situation 3:GlobalEnv��saveUserInfoAndExtensionǰ����error������ִ��saveUserInfoAndExtension���׳��쳣������ͨ��ʹ��catch�������쳣����ִ��saveUserLog(userLog)�����Բ���ع�log(log)������ֻ�ǻع���saveUserInfoAndExtension��
	
	����������һ��AfterThrow��Advice�����׳��쳣�ķ����������������һЩ����Ĳ�����
	ע:<ref local="logAdvisor" /><ref local="validationAdvisor" />����˳���Ƿǳ��Ĺؼ��ģ����logAdvice��ǰ����ȻvalidationAdvice�ڼ������׳����쳣�����ǻ�ִ��logAdvice�е�afterThrow����
	   ���validationAdvisor��ǰ����validationAdvice�ڼ������׳����쳣�󣬲���ִ��logAdvice�ķ����ˣ���Ϊ����쳣�Ѿ�����Ϊ����service�׳����ˣ�����logAdvice�����ٲ����ˡ�

	   

##### GWT #####	   

1. HelloWorld Sample: ��yeep_gwt\source\com\yeep\gwt\study\sample\helloWorld\ Ŀ¼�£���ʾ��������i18n���Լ� button��menu�ļ�Ӧ��

2. WidgetSample : ��yeep_gwt\source\com\yeep\gwt\study\sample\widgetSample\ Ŀ¼�£���ʾ�������� ����widget component��ʹ��

   (1) Button:  ���ǿ�������һ�� ClickListener ��ʵ�� public void onClick(Widget sender) ��������Ӧһ��button���¼�
   
   (2) Hyperlinks: ÿһ��Hyperlinks���������Ҫʵ��HistoryListener�ӿڣ�ʵ�� onHistoryChanged(String historyToken) ��������Ӧ�¼��������� *.Html �ļ��м��� <iframe id="__gwt_historyFrame" style="width:0;height:0;border:0"></iframe> ��֧�֡� 

   (3) Menu:  MenuBar��MenuItem ���ǿ���ʵ��һ��Command�࣬����MenuItem��Command��
   
   (4) HTML:  ���Դ���HTML("...") ������ʵ��HTML����
   
   (5) Tree:  ���Զ�һ��Tree������� TreeListener ��������ʵ���������� onTreeItemSelected(TreeItem item) --- ����ĳ��Itemʱ������onTreeItemStateChanged(TreeItem item) --- ��ĳ��Item��״̬�����ı�ʱ����	   

3. rpcSample : ��study_gwt\source\com\yeep\gwt\study\sample\rpcSample\ Ŀ¼�£���ʾ��������2��rpc�ĵ���   
   ( http://localhost:18080/yeep/gwt/com.yeep.gwt.study.sample.rpcSample.RpcSample/RpcSample.html)     
   (1) ��hosted mode�µ�rpc����
   (2) ����Spring�ṩ��gwt-servlet.xml�����ã������GWT Service����Spring Service  
	   
	   



#### Junit & Easy Mock ####
1.Easymock: com.yeep.study.junit���£�չʾ����easymock�Խӿڷ����Ĳ�������


#### Cglib ####
cglib��ȫ����Code Generation Library��������������̬�̳�Java�����ʵ�ֽӿڡ�
����Enhancer����һ��ԭ��������࣬�������ú�callback��proxy�� ��ԭ�����ÿ���������ö���תΪ����ʵ����MethodInterceptor�ӿڵ�proxy��intercept() ������
	public Object intercept(Object o,Method method,Object[] args,MethodProxy proxy)
��intercept()������������ִ��Object result=proxy.invokeSuper(o,args);��ִ��ԭ�к�������ִ��ǰ������Լ��Ķ������ı����Ĳ���ֵ������AOP�е�around advice��
�������� com.yeep.study.cglib.EnhancerSample



#### Java Core ####

1. ����: ��com/yeep/study/javacore/generics�е�GenericsTest.javaչ���˷��͵�5��Ӧ��

��ν������ָ���Ͳ�����(parameterized types)��Java��һ��ǿ���͵�����, ��J2SE 1.4�Լ���ǰ�İ汾��, �����ڶ���һ��Java��, �ӿڻ��߷�����ʱ��, ����ָ�����������͡�
�����������ࡢ�ӿڻ��ߺ���ʱ, ���������ʱ��ָ��ĳЩ�����ľ�������, ������һ�����Ͳ�������. ��ʹ�������, �ӿ�, ���߷�����ʱ��, ������Ͳ�����һ���������������档

1)�򵥵ķ���������

		List<Integer> integerList = new ArrayList<Integer>();//�����ֻ�ܴ��Integer���͵��б�
		integerList.add(new Integer(1));
		// integerList.add(new String("Another Element")); // ����ͼ���String���͵ı���ʱ������ֱ������
		Integer integer = integerList.get(0); // ʹ�õ�ʱ����Ҫ�������͵�ת����
		
2)���ͺ����ࣺ
		List<String> stringList = new ArrayList<String>();
		List<Object> objectList = stringList;//������������
		������ʹ��objectListָ��stringList������ͨ��objectList������һ��String��list�����ǿ��Բ�����������ȥ�������stringlList�б���Ĳ�����String����������ͼ����ȡ��Ԫ�ص�ʱ�򣬻�õ�����Ľ����Java����������ֹ�������

		���Foo��Bar��һ��������(��������ӽӿ�)����G��ĳ�ַ�����������ôG<Foo>��G<Bar>�������Ͳ���������
		
3)�����ࣺGenericsList���ඨ���ʱ�����������

4)ͨ�����ʹ�ã�����ʾ���е�����

		Collection<Object>��ʾֻ������Object���Collection���ϣ�������������Object�����࣬�μ�2)���ͺ�����
		Collection<?> ��ʾ���������е����͡�Collection<?>(����Ϊ:"collection of unknown")
		Collection<? extends String> ��ʾ��������String��String������
		
5)���ͷ����� ����������Ҳ���Ա����ͻ���������˵������һ�����߶�����Ͳ�����
						 ���ͺ����������Ͳ�����������ʾ������һ����������֮���������ϵ�����߲������䷵��ֵ��������ϵ�����û��������������ϵ����Ӧ��ʹ�÷��ͷ�����
						 
	���ͷ�����ͨ����ĶԱȣ�
			boolean containsAll(Collection<?> c); ---> <T> boolean containsAll(Collection<T> c);
    		boolean addAll(Collection<? extends E> c); ---> <T extends E> boolean addAll(Collection<T> c);

6)�����е��Ͻ��½�
�Ͻ�: �Ͻ���extends�ؼ�����������ʾ�����������Ϳ�������ָ�������ͣ������Ǵ����͵����ࡣ�ο� com.yeep.study.javacore.generics.UpperLowerBoundTest
eg: public void upperBound(List<? extends Date> list, Date date)   
    {   
		Date now = list.get(0);   
		System.out.println("now==>" + now);   
		//list.add(date); //��仰�޷�����   
		list.add(null);//�����Ա��룬��Ϊnullû��������Ϣ   
    }  


Ϊʲô���޷������أ�ʵ�ʵ���ʱ�����list������java.util.Date��ĳ������Ĳ��������ͣ�
eg: public void testUpperBound()   
	{   
		List<Timestamp> list = new ArrayList<Timestamp>();   
		Date date = new Date();   
		upperBound(list,date);   
	}  

Ҳ����˵������upperBound������ʵ�ʵ�list��List<Timestamp>���������һ��Date���ͣ��϶��ǲ��еġ��෴����ȡ����ʱ������ʵ�ʵ�list��ʲô���ͣ�������֪�������ٻ᷵��һ��Date���ͣ�������foreach��get��û�����⡣ ���޷��ж�Ԫ��date������Date�ܷ�һ������List<? extends Date>ʱ���������޷�ͨ����

��ô��ν���أ�����ʹ�÷��ͷ������ڷ��ͷ����б�֤��date�����ͺ�list�ķ������Ͷ���T����һ�µģ����Կ���ͨ�����롣���﷽�������е�T��Ϊһ�ֲ�������Ϣ����洢��java�ֽ����У�T��ʵ�������ɵ���ʱ�Ĳ���������
public <T extends Date> void upperBound2(List<T> list, T date)   
{   
    list.add(date);   
}  


�½磺�½���super������������ʾ�����������Ϳ�������ָ�������ͣ������Ǵ����͵ĸ����ͣ�ֱ��Object���ο� com.yeep.study.javacore.generics.UpperLowerBoundTest
eg:	public void lowerBound(List<? super Timestamp> list)   
	{   
		Timestamp now = new Timestamp(System.currentTimeMillis());   
		list.add(now);   
		//Timestamp time = list.get(0); //���ܱ���   
	}  



����Ϊʲô����ͨ�������أ��������ô���: 
eg:	public void testLowerBound()   
	{   	
		List<Date> list = new ArrayList<Date>();   
		list.add(new Date());   
		lowerBound(list);   
	}  

lowerBound�����е�List<? super Timestamp>��ʾ���list�Ĳ������Ϳ�����Timestamp��Timestamp�ĸ���.
�������Դ����ʵ�ʴ������һ��List<Date>���͡���List<Date>��addһ��Timestamp�϶���û������ģ���list.get()�������صĶ������Ϳ�����Date������Object���㲻��˵list.get(0)���صľ���һ��Timestamp����������������ת���ˣ��������޷������������ﲻ�ܱ��롣��java����ʵ�ֵĲ��÷����ͣ������������µ�α���룺 
	public void lowerBound(List list)   
	{   
		Timestamp now = new Timestamp(System.currentTimeMillis());   
		list.add(now);   
		Timestamp time = (Timestamp)list.get(0); //  
	}

2. Annotation:��com/yeep/study/javacore/annotation��չ����Annotation��Ӧ��

Annotation�ṩһ�ֻ��ƣ��������Ԫ����:�࣬���������ԣ����������ر���������Ԫ������ϵ�������������������Խ�Ԫ���ݴ洢��Class�ļ��С����������������������Ը�����ЩԪ�������������ʹ����Щ����Ԫ�ػ�ı����ǵ���Ϊ��
��J2SE5.0��java.lang����Ԥ����������annotation��Override��Deprecated��SuppressWarnings��



###### WebService ######
Web Service��Ҫ��Ϊ��ʹԭ����������վ��֮�����Ϣ�ܹ��໥ͨ�š�����������һ�ֽӿڡ� 
Web Service��ʹ�õ���Internet��ͳһ�����ŵı�׼����HTTP��XML��SOAP���򵥶������Э�飩��WSDL�ȣ�����Web Service�������κ�֧����Щ��׼�Ļ�����Windows,Linux����ʹ�á�
SOAPЭ�飨Simple Object Access Protocal,�򵥶������Э�飩,����һ�����ڷ�ɢ�ͷֲ�ʽ������������Ϣ�����Ļ���XML��ͨѶЭ�顣

1. 	Axis2 : 
	����Axis2��API����Web Service������һ������� 4 ������ 
		a.��дService���� 
		b.�� service.xml ������������� 
		c.����һ�� *.aar �ķ������
          �������Ľṹ����: ***.aar
							 |
							 |---- package
							 |  |     
							 |  |---- ***Service.java
							 |
							 |---- META-INF
								|
								|---- service.xml
						
		d.��������: ����Axis-Servlet����*.aar����../WEB-INF/services/Ŀ¼��

(1) HelloWorld: yeep_wx/com.yeep.study.webservice.axis2.helloWorld
	������չ����һ���򵥵�WebService��Ӧ�ã��ֱ������2�ֵ���Ϣ���� RPCMessageReceiver��RawXMLINOutMessageReceiver��
    RawXMLINOutMessageReceiver��service�ķ�������û�в�����ֻ�ܽ���OMElement���͵Ĳ���������Ҳ��OMElement���͡�
	RPCMessageReceiver�Ĳ��������������JAVA���ͣ����ؿ���ʹ�����JAVA���͡�RPCMessageReceiver����OMEelment��JAVA���ͻ���JAVA���͵�OMElement��ת����

	���ǿ�������com.yeep.study.webservice.axis2.HelloWorldClient.java������Web Service��Ҳ����ʹ��URL: http://localhost:18080/yeep/services/helloWorld/hello1?username=Roger
    hello2ʹ����AXIOM(The Axis Object Model)����ɶ���Ĵ���

(2) AxiomSample: yeep_wx/com.yeep.study.webservice.axis2.axiomSample 
	������չ����Axis2��ʹ��AXIOM��������ķ�ʽ��ͨ��ʹ�� Streaming API for XML (StAX) Pull ��������AXIOM���Կ��ƽ������̣����ṩ�ӳٹ���֧�֡��ӳٹ�����ָ AXIOM ����ȫ��������ģ�ͣ�ģ�͵����ಿ�ֻ����û������󹹽���
    ���ǿ�������com.yeep.study.webservice.axis2.AxiomSampleClient.java������Web Service
	
    callSample1: չʾ�˼򵥵Ľ���AXIOM����Ĺ��̣������ڵ㡢���Ե�
	callSample2: չʾ����StAXOMBuilder��XMLStreamReaderһͬ����AXIOM�Ĺ��̡�
				 
				 ���͵�ʵ�ִ���:
				 1.BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(��MyFilePath��))); 
				   ����һ��ԭʼ�� xml ������
				 
				 2.XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(reader);
				   ������ʽ (pull)xml ������
				 
				 3.StAXOMBuilder builder = new StAXOMBuilder(OMAbstractFactory.getOMFactory(),parser); 
				   ���� StAXOMBuilder ���� 
				   
				 4.OMElement root = builder.getDocumentElement(); 
				   ��ȡ���ڵ����
 
        
		
		
###### Swing ######
		
Component Sample
1. 	LabelIconSample: չ����Label,Icon,ImageIcon�����ӣ���������com.yeep.study.swing.component.LabelIconSample

2. 	ButtonSample: չ����Button,ToggleButton,CheckBox,RadioButton�����ӣ���������com.yeep.study.swing.component.ButtonSample	

3. 	ListSample:չ����JList,ComboBox�����ӣ���������com.yeep.study.swing.component.ListSample

4. 	RootPaneSample: չ����RootPane���������ӣ���������com.yeep.study.swing.component.RootPaneSample
                    Swing�Ķ�������(JFrame,JWindow,JApplet)��������һ��JRootPane����JRootPane��һ��Swing�����㡣
					
					JRootpane ��һ�� glassPane ��һ����ѡ�� menuBar �Լ�һ�� contentPane ��ɡ���JLayeredPane ������� menuBar �� contentPane����glassPane λ�����д���֮�ϣ��Ա��ܹ���ȡ����ƶ������� glassPane���� contentPane ���ƣ�������һ������������Ҳ�������� glassPane �����л��ơ����� glassPane �ϵ�������ͼ��ɺ������µĴ��壬������߽�����ơ�
					GlassPane��JLayeredPane���ǳ���JRootPane�ġ�GlassPaneȱʡ������ǲ��ɼ��ģ�������ǿ�������JLayeredPane��
					
					JLayeredPaneֱ�Ӱ�����ContentPane�����Ӧ�ó����������MenuBar��JLayeredPane������MenuBar��ע��JLayeredPane����û�в��ֹ���������������Ĳ����������ĸ�����JRootPane�Ĳ��ֹ�����RootLayout����ɵġ� 
					JLayeredPane Ϊ JFC/Swing �����������ȣ������������Ҫʱ�����ص���Integer ����ָ��������ÿ���������ȣ����б�Žϸߵ����λ���������֮�ϡ�
						DEFAULT_LAYER ��������λ�ڵı�׼�㡣������ײ㡣 
						PALETTE_LAYER	��ɫ���λ��Ĭ�ϲ�֮�ϡ����Ƕ��ڸ����������͵�ɫ������ã���˿���λ���������֮�ϡ� 
						MODAL_LAYER	�ò�����ģʽ�Ի������ǽ����������������й���������ɫ����׼��������档 
						POPUP_LAYER	��������ʾ�ڶԻ�������档����������Ͽ򡢹�����ʾ�����������ı������ĵ���ʽ���ڽ��������������ɫ����������ǵĶԻ���֮�ϡ� 
						DRAG_LAYER	�϶�һ�����ʱ����������ط��䵽�϶����ȷ�����䶨λ�������е������������֮�ϡ�����϶��󣬿ɽ�������ط��䵽�������㡣 
					����ʹ�� JLayeredPane �ķ��� moveToFront(Component)��moveToBack(Component) �� setPosition ��������ڲ��ж�������ض�λ��������ʹ�� setLayer �������ĸ�����ĵ�ǰ�㡣 

	
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
				
5.	InternalFrameSample: չ����InternalFrame���������ӣ���������com.yeep.study.swing.component.InternalFrameSample
						 JInternalFrame��ʹ�ø�JFrame����һ����������󻯡���С�����رմ��ڡ�����˵��ȹ���;Ψһ��ͬ����JinternalFrame��lightweight component ,Ҳ����˵JInternalFrame���ܵ������֣��������������ϲ�����ϡ�
						 Swing�ṩ���ֲַ���壺JlayeredPane��JDesktopPane�� JDesktopPane��JLayeredPane�����࣬ר��Ϊ�����ڲ���ܣ�JInternalFrame�������á�

6.	DialogSample : չ����JDialog�����ӣ���������com.yeep.study.swing.component.DialogSample
				   JOptionPane��һ��Dialog�Ĺ����࣬��ʵ����һ��Dialog��ģ�壬������ͼ�ꡢ��Ϣ�����롢��ť
				   
7.	SpecialPanelSample : չ����һЩ����panel�����ӣ���������com.yeep.study.swing.component.SpecialPanelSample	
						 SplitPanel��ScrollPanel��TabPanel.
						 ScrollPanel��Viewport,Row header,Column header,Vertical scrollbar,Horizontal scrollbar,Four corners (upper left, upper right, lower left, and lower right) ���

8.	MenuSample: չ���˲˵������ӣ���������com.yeep.study.swing.component.MenuSample				   
				   
9.	ToolBarSample: չ���˹����������ӣ���������com.yeep.study.swing.component.ToolBarSample		


###### JNI ######
1. JIntellitype : ������JIntellitype jar��ʾ�����������̨�����¼��Ĳ��� 
                  �������� com.yeep.study.jni.JIntellitype.JIntellitypeTest			   
				   
				   
###### SWT/JFace ######				   
-Djava.library.path=D:\Work\yeep\Study\lib\swt				   
				   


######  XML ѧϰ #######
1. XSLT �� XML ת��Ϊ XHTML: �鿴CDCatalog.xml��CDCatalog.xsl
  �� XML �ĵ���"�鿴com\yeep\study\xml\xslt\CDCatalog.xml"����� XSL ��ʽ������ <?xml-stylesheet type="text/xsl" href="CDCatalog.xsl"?>
  ���ʹ�õ���������� XSLT���Ϳ��Կ���ת����� XHTML

2. ���������XML��com\yeep\study\xml\parser\XmlStringParserSample.htmlչ�����������������XML�ַ���������
                  com\yeep\study\xml\parser\XmlFileParserSample1.html��չ�����������������XML�ļ�������(ʹ���������XMLDOM)
				  com\yeep\study\xml\parser\XmlFileParserSample2.html��չ�����������������XML�ļ�������(ʹ���������XmlHttpRequest)
 
  
######  EJB3 #######  
1. ��װGlassFish 2.1: 
   (1) ��װJDK 1.5 �� 1.6
   (2) �������д�����������: java -Xmx256 -jar glassfish-installer-*****.jar
   (3) �ڰ�װĿ¼����ant����ʼ��glassfish������: .\lib\ant\bin\ant -f setup.xml
       ����Ҳ���������޸�setup.xml�еĳ�ʼ����
   (4) ��ϵͳ������������� GLASSFISH_HOME
   (5) �������д���������������������ֹͣ������: asadmin start-domain domain1
                                                 asadmin stop-domain domain1
   (6) ����http://localhost:4848����console
   (7) ��Ӧ�ó����CLASSPATH�����appserv-deployment-client.jar��appserv-ext.jar��jmxremote_optional.jar��appserv-rt.jar
   
2. Session Bean : Session Bean��ʵ��ҵ���߼����࣬���Է�Ϊ��״̬����״̬���֡���״̬��Bean����ά���Ự״̬����ζ��EJB����ҪΪÿ���û�����һ��Bean��ʵ��������״̬Bean����Ҫά���Ự״̬����ʱһ��bean��ʵ������Ϊ����û�����
   һ��Session Bean��Ҫ����ӿ�(Զ�̻��߱���)��Bean class:
   (1) Զ�̽ӿ�(Remote Interface): ������Session bean��ҵ�񷽷�����Щ�������Ա�����EJB���������Ӧ�÷��ʡ�
   (2) ���ؽӿ�(Local Interface): ������Session Bean��ҵ�񷽷�����Щ����ֻ�ܱ�ͬ����EJB�����ڵ�Ӧ�÷��ʡ���Local�ӿڿ�������Beanֱ�����ڴ潻����û�зֲ�ʽЭ��Ŀ�����
   (3) Bean��(Bean class): bean class������ҵ���߼���������߱�һ��Զ�̻򱾵ؽӿ�

3.Stateless Session Bean ---
3.1 ֻʵ��Remote Interface����״̬Session Bean: HelloWorld��һ��ֻʵ����Remote�ӿڵ�EJB
    (1) ����һ����ͨ�ӿ�(com.yeep.study.ejb3.helloWorld.HelloWorld.java)
    (2) ��дBean class (com.yeep.study.ejb3.helloWorld.impl.HelloWorldBean.java)
        Bean����������ע��@Stateless��@Remote��
	  @Stateless��ָ������һ����״̬�ỰBean��@Stateless��name()������ָEJB�����֣���������EJB��jar������ȫ��Ψһ�ġ�mappedName()������ָBean��ȫ��JNDI���ƣ����������weblogic��sun��������glassfish��Ч
	  
	  @Remoteָ�����Bean��remote�ӿڡ�Bean������ж��remote�ӿڡ�
    (3) ���EJB�������ù��߻���ANT�����һ��EJB������Ӧ�þ�������Ŀ¼�ṹ��
        EJBӦ�ø�Ŀ¼
	     |
	     |---- **/*.class
	     |
	     |---- META-INF
	             |
			     |----MANIFEST.MF
   
    (4) ����EJB��������Ҫ֪��EJB��JNDI��Ȼ��ͨ�������Ļ�ȡEJB
        ��com.yeep.study.ejb3.helloWorld.Test.java �п��Կ�������ͨ��2�ַ�ʽ��ȡJNDI��һ����Properties�ڳ��������ã�һ������JNDI.properties�ļ������á�
      Ҳ���Է���http://localhost.../study/jsp/study/ejb/helloWorld/HelloWorld.jsp
	  HelloWorld���EJB������Remote�ӿڣ����Բ���study.war��Test���Ƿ���ͬһ��Glassfish�������������ҳ�涼����ʾ������Ϣ��
	  
3.2. ֻʵ��Local�ӿڵ���״̬Session Bean: LocalSessionBean
     ����ͨ��http://localhost.../study/jsp/study/ejb/localSessionBean/LocalSessionBean.jsp������
   
3.3 ͬʱʵ����Զ���뱾�ؽӿڵ�Session Bean :��LocalRemoteSessionBean
    ����ͨ��http://localhost.../study/jsp/study/ejb/localRemoteSessionBean/LocalRemoteSessionBean.jsp������
    Stateless Session Beanһ����ʵ�����󣬾ͻᱻ����ʵ���أ����Ա������û�ʹ�ã������ӵ���Լ�������(���籾���� count����)���ܵ������û��������ۼ�Ӱ�졣 
	
3.4 EJB��ʵ���������: EJB�ṩ�����ֹ������beanʵ���Ļ��ƣ�ʵ���ػ�(instance pooling)�ͼ���(activation)
    Stateless Session Bean�ᱻʵ������ʵ�����У���Ӧ����Ҫʹ��Beanʱ���������ʵ�����л�ȡһ��ʵ����ʹ����Ϻ��ٷ������
    stateful session bean���ڲ�ͬ�ķ�������֮��ά���Ự״̬����ʹ�ü��������ʵ������������Դ����    �ġ���EJB��������Ҫ��ʡ��Դʱ���ջ�stateful session bean���ͷ�����ռ�е�������Դ������������    �ֵĻỰ״̬���л��������洢���У�����ͻ��˶Ը�EJB�����ٴη�������EJB����������ʵ����һ��stateful session bean�����Ӹ����洢���н�֮ǰ��״̬�ָ���
	
3.5 stateless session bean������������״̬
    ��״̬(No state)����δ����ʼ��
    ��״̬(Pooled state)���Ѿ���������窻�
    ����״̬(Ready state)���Ѿ���һ��EJB���������������Ӧ�������õ�׼��



###### Ant ######
1. �Զ���Ant����: com.yeep.study.ant.Getfilelist.java չʾ���Զ���Ant���񣬿�������build-core.xml�е�test-custom-ant-task�������õ����н�������Կ�����������ļ������ļ�����ѭ����ʾ��




###### MySQL ######
1. ��������
   1)�޸�my.ini
   
   [mysql]
   default-character-set=utf8 -------->�ĳ�utf8

   [mysqld]
   default-character-set=utf8 -------->�ĳ�utf8

   2)�޸�DataĿ¼�����ݿ��db.opt�ļ�
   default-character-set=utf8 -------->�ĳ�utf8
   default-collation=utf8_bin -------->�ĳ�utf8

   3)���´������е����ݱ�����޸Ĵ���������, ��֤���ݱ��Ĭ���ַ�����Ϊutf8
   
     create table XXXX 
	 (      
      .....
	 ) engine=myisam default charset=utf8; 



   
###### Demo ######
1. Shudu: �����Ľⷨ������ʹ��http://localhost:18080/yeep/gwt/com.yeep.gwt.app.shudu.Shudu/Shudu.html����
   ҵ���������study_core\com.yeep.app.shudu
   ҳ�����ʹ��GWT��Ϊչ�ַ�ʽ�������yeep_gwt\com.yeep.gwt.app.shudu

2. ����С����: ����һ��ʮ������N��д�´�1��ʼ����N������������Ȼ����һ�����г��ֵ�����"1"�ĸ�����
   (com.study.app.demo.CountNumber)   

