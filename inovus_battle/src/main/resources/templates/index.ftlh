<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
</head>
<body>
<div id="content">
    Hello, ${name}
    <div id="res">
        <form action="#" id="head">
            do you wanna start the cat battle?
            <a id="query" onclick="f()" href="#">VOTE</a>
            <input value="START" type="hidden" id="ind">
        </form>
        <table>
            <tr>
                <form action="#">
                    <input type="hidden" id="ind1">
                    <td id="cat1">

                    </td>
                </form>
                <form action="#">
                    <input type="hidden" id="ind2">
                    <td id="cat2">

                    </td>
                </form>
            </tr>
        </table>
    </div>
    <a href="/reset">RESET</a>


</div>
</body>


<script type="application/javascript">
    function f() {
        $.ajax({
            url: "/start",
            data: {"ind": $("#ind").val()},
            dataType: "json",
            success: suc,
            error: err

        })
    }
    function f1() {
        $.ajax({
            url: "/start",
            data: {"ind": $("#ind1").val()},
            dataType: "json",
            success: suc,
            error: err

        })
    }
    function f2() {
        $.ajax({
            url: "/start",
            data: {"ind": $("#ind2").val()},
            dataType: "json",
            success: suc,
            error: err

        })
    }

    function suc(msg) {
        if (msg) {
            $("#head").html("");
            $("#cat1").html("");
            $("#cat1").append("<a href='#' onclick='f1()'>" + msg.cat1.id + " " + msg.cat1.name + "<img src='cats" + msg.cat1.image + "'> </a>")
            $("#ind1").val(msg.cat1.id);
            $("#cat2").html("");
            $("#cat2").append("<a href='#' onclick='f2()'>" + msg.cat2.id + " " + msg.cat2.name + "<img src='cats" + msg.cat2.image + "'> </a>");
            $("#ind2").val(msg.cat2.id);
        }
    }

    function err() {
        window.location.href = 'finish'
    }

</script>


</html>