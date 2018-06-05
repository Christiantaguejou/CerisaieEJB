<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Planning de Cerisaie</title>
    <%@ include file="includes/includeTab.jsp" %>
    <%@ include file="includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-12 col-xs-12">
            <div class="limiter">
                <div class="container-table100">
                    <div class="wrap-table100">

                        <div class="table100 ver2 m-b-110">
                            <div class="table100-head">
                                <table>
                                    <thead>
                                    <tr class="row100 head">
                                        <th class="cell100 column1">Sport</th>
                                        <th class="cell100 column2">Date de Location</th>
                                        <th class="cell100 column3">Date de Debut</th>
                                        <th class="cell100 column4">Date de Fin</th>
                                        <th class="cell100 column5">Nbre de Location</th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>

                            <div class="table100-body js-pscroll">
                                <table>
                                    <tbody>
                                    <c:forEach items="${activities}" var="item">
                                        <tr class="row100 body">
                                            <td class="cell100 column1">${item.sportEntity.libelleSport}</td>
                                            <td class="cell100 column2">${item.activityEntity.dateJour}</td>
                                            <td class="cell100 column3">${item.sejourEntity.datedebSej}</td>
                                            <td class="cell100 column4">${item.sejourEntity.dateFinSej}</td>
                                            <td class="cell100 column5">${item.activityEntity.nbLoc}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    $('.js-pscroll').each(function(){
        var ps = new PerfectScrollbar(this);

        $(window).on('resize', function(){
            ps.update();
        })
    });
</script>


</body>
</html>