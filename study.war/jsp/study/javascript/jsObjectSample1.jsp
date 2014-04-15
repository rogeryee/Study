<html>
<head>
<title>Javascript Object Sample1</title>

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

    Object.prototype.toString = function (){return 'Default toString()'};

    //------------------------------------------------------------------------------------------------------------------
    // Object Defination 1
    // Step1: var obj = new Object();
    var obj1 = new Object();
    obj1.name = 'Roger';
    obj1.age = 26;
    obj1.desc = function (){return 'Name:' + this.name + ',Age:' + this.age};

    obj1.toString = function(){return 'Person --- Object Defination 1'};//overwrite the toString() method;

    //------------------------------------------------------------------------------------------------------------------
    // Object Defination 2
    // Step1: var obj =
    //        {
    //            name:'xxx',
    //            age:yyy,
    //            desc:function(){...}
    //        }
    var obj2 =
    {
        name : 'Adams',
        age  : 27,
        desc : function(){return 'Name:' + this.name + ',Age:' + this.age},
        toString : function(){return 'Person --- Object Defination 2'}// overwrite the toString() method
    }

    //------------------------------------------------------------------------------------------------------------------
    // Object Defination 3
    // Step1: function CustomerObject(){};
    // Step2: var obj = new CustomerObject();
    function Person(){}

    var obj3 = new Person();
    obj3.name = 'Phoebe';
    obj3.age = 21;
    obj3.desc = function(){return 'Name:' + this.name + ',Age:' + this.age};

    Person.prototype.toString = function(){return 'Person --- Object Defination 3'} ;// overwrite the toString() method

    //------------------------------------------------------------
    // Object Defination 4
    // Step1: var CustomObject = function (){...};
    // Step2: var obj = new CustomerObject();
    var AnotherPerson = function()
    {
        this.name = 'default name';
        this.age = 20
        this.toString = function(){return "Person --- Object Defination 4"}// overwrite the toString() method
    }

    var obj4 = new  AnotherPerson();

</script>
    
</head>
<body>

    <!--
        There are four kinds Defination for Ojbect
    -->
    <input type="button" value="Object Definition 1" onclick="alertObject(obj1);" >&nbsp;
    <input type="button" value="Object Definition 2" onclick="alertObject(obj2);" >&nbsp;
    <input type="button" value="Object Definition 3" onclick="alertObject(obj3);" >&nbsp;
    <input type="button" value="Object Definition 4" onclick="alertObject(obj4);" >&nbsp;
    <br><br>

</body>
</html>