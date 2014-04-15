<html>
<head>
<title>Javascript Object Sample2</title>

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

    //------------------------------------------------------------------------------------------------------------------
    // Five kinds of Attribute Defintions


            
    // 1. define attribute as static by using 'FunctionName.attributeName'
    //    And can be used like 'func.attr', not like 'new Func().attr'
    Person.firstColumn = '1st Column';
    function Person()
    {
        // 2. define attribute in constructor by using 'this.'. These attrs are of the Object you create
        //    And can be used like 'new Func().attr'
        this.secondColumn = '2nd Column';
        var thirdColumn = '3rd Column';  // can not be used either way
        this.name = 'Person Instance name'; // can overwrite the attribute defined in 'Person.prototype.name'
    }

    // 3. defined attribute in Object or Parent Class by using 'Object.prototype.attributeName'
    //    can be used like either 'func.attr' or 'new Func().attr‘
    Object.prototype.toString = function ()  {return 'Object toString'} ;
    Object.prototype.name = "Object-->name" ;
    Object.prototype.porotype_name = "Object-->porotype_name" ;
    Object.prototype.parent_name = "Object-->parent_name" ;

    // 4. defined attribute in Function.prototype by using 'Func.prototype.attributeName'
    //    can be used like either 'func.attr' or 'new Func().attr‘
    Person.prototype.name = "Person-->name" ;
    Person.prototype.porotype_name = "Person-->porotype_name";

    var person = new Person();

    alert('Person.firstColumn = ' + Person.firstColumn);// '1st Column'
    alert('Person.secondColumn = ' + Person.secondColumn); // undefined
    alert('Person.thirdColumn = ' + Person.thirdColumn); // undefined

    alert('Person.name = ' + Person.name); // "Object-->name"
    alert('Person.porotype_name = ' + Person.porotype_name); // "Object-->porotype_name"
    alert('Person.parent_name = ' + Person.parent_name); // "Object-->parent_name"
            
    alert('person.firstColumn = ' + person.firstColumn); // undefined
    alert('person.secondColumn = ' + person.secondColumn); // '2nd Column'
    alert('person.thirdColumn = ' + person.thirdColumn); // undefined

    alert('person.name = ' + person.name); // "Person-->name"
    alert('person.porotype_name = ' + person.porotype_name); // "Person-->porotype_name"
    alert('person.parent_name = ' + person.parent_name); // "Object-->parent_name"
            
    alertObject(person);

</script>
    
</head>
<body>

</body>
</html>