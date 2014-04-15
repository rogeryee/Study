<html>
<head>
<title>Javascript Object Sample3 (Inheritance of Javascript)</title>

<script language="javascript">
     
    // General Function for Alerting attribute of Objects
    function alertObject(obj)
    {
        // iterate for all elements of object
        for(var key in obj)
        {
            alert('Attribute:' + key + ':' + obj[key] + '(type:' + typeof (obj[key]) + ')');
            if(typeof(obj[key]) == 'function' )
                alert('Excute function:' + (obj[key])());
        }

        alert("obj:" + obj);
    }
            
    // Use function to implement inheritance
    // Superclass
    function superClass()
    {
      this.bye = superBye;
      this.hello = superHello;
    }

    // subclass
    function subClass()
    {
      this.inheritFrom = superClass;
      this.inheritFrom();
      this.bye = subBye;
    }

    function superHello()
    {
      return "Hello from superClass";
    }

    function superBye()
    {
      return "Bye from superClass";
    }

    function subBye()
    {
      return "Bye from subClass";
    }

    var newClass = new subClass();

    // Use prototype to implement inheritance
    function Person()
    {
      this.name = "Rob Roberson";
      this.age = 31;
      this.desc = function () {return this.name + "," + this.age};
    }

    function Employee()
    {
      this.dept = "HR";
      this.manager = "John Johnson";

      // override the method desc in Person
      this.desc = function () {return this.name + "," + this.age + "," + this.dept + "," + this.manager};
    }

    Employee.prototype = new Person();

    var roger = new Employee();

</script>
    
</head>
<body>

    <!--
        There are 2 kinds Defination for Inheritance
    -->
    <input type="button" value="Inheritance Definition 1" onclick="alertObject(newClass);" >&nbsp;
    <input type="button" value="Inheritance Definition 2" onclick="alertObject(roger);" >&nbsp;

</body>
</html>