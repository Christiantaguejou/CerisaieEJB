<%@ taglib prefix="h" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 24/05/2018
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Se connecter</title>
</head>
<body>
<div id="body">
    <div class="panel">
        <h2>Sign In</h2>

        <p><b>Vous avez déjà un compte ?</b></p>
        <table cellspacing="0" cellpadding="5" width="100%" border="1">
            <tr>
                <td valign="top">
                   <form name='connexion' method="post" action="doSignIn.htm">
                        <TABLE cellSpacing="0" cellPadding="5" border="0">
                            <TR>
                                <TD align="center" colSpan="2"><B>Yes.</B></TD>
                            </TR>
                            <TR>
                                <TD align="right"><B>Login :</B></TD>
                                <TD>
                                    <input type="text" class="form-control" id="login" name="login" placeholder="login" required>
                                </TD>
                            </TR>
                            <TR>
                                <TD align="right"><B>Password:</B></TD>
                                <TD>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="mot de passe" required>
                                </TD>
                            </TR>
                            <TR>
                                <TD align="center" colSpan="2">
                                    <button type="submit" class="btn btn-default">Connexion</button>
                                </TD>
                            </TR>
                        </TABLE>
                   </form>
                </td>
                <TD vAlign="top">
                    <form name='inscription' method="post" action="inscriptionClient.htm">
                        <TABLE cellSpacing="0" cellPadding="5" border="0">
                            <TR>
                                <TD align="center" colSpan="2">
                                    <B>Je n'ai pas de compte. Je m'inscris</B></TD>
                            </TR>

                            <TR>
                                <TD align="center" colSpan="2">
                                    <button type="submit" class="btn btn-default">S'inscrire</button>
                                </TD>
                            </TR>
                        </TABLE>
                    </form>
                </TD>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
