<html>
<head>
<title>Prototype Sample</title>
<Script type="text/javascript" src="/yeep/js/prototype.js"></script>

<script language="javascript">

    Event.observe(window, 'load', showMessage, false);

    function showMessage()
    {
        alert('Window loaded.');
    }

</script>

</head>
<body>

    <input type=checkbox id=myChk value=1> Test for PrototypeClass

    <script language="javascript">

        //declaring the class
        var CheckboxWatcher = Class.create();

        //defining the rest of the class implmentation
        CheckboxWatcher.prototype = {

            initialize: function(chkBox, message) {
                this.chkBox = $(chkBox);
                this.message = message;

                //assigning our method to the event
                this.chkBox.onclick = this.showMessage.bindAsEventListener(this);
            },

            showMessage: function(evt) {
                alert(this.message + ' (' + evt.type + ')');
            }
        };

        var watcher = new CheckboxWatcher('myChk', 'Changed');

    </script>

    <br><br>
    Select Observer
    <select id="mySelect">
        <option value="China">China</option>
        <option value="USA">USA</option>
    </select>

    <script language="javascript">

        Event.observe($('mySelect'), 'change', selectMsg, false);

        function selectMsg()
        {
            alert('Select has been changed!');
        }

    </script>

</body>
</html>