<%-- 
    Document   : inicioRepresentante
    Author     : rafal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Liga de f&uacute;tbol ESCOM-IPN</title>

        <!-- Bootstrap 4 -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Custom Styles for this theme -->
        <link rel="stylesheet" href="css/navbar-fixed.css">

        <!-- Font awesome --  biblioteca de iconos -->
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.6.3/css/font-awesome.min.css">

        <!-- Estilos particulares para esta pagina -->
        <link rel="stylesheet" href="css/inicioRepresentante.css">

        <!-- Estilos de lobibox (notificaciones) -->
        <link rel="stylesheet" type="text/css" href="plugins/lobibox/css/lobibox.min.css">

        <!-- Estilos del form validator-->
        <link rel="stylesheet" type="text/css" href="plugins/form-validator/theme-default.min.css">

        <!-- Scripts -->
        <script src="js/jquery-3.2.0.min.js"></script>
        <script src="js/tether.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/navbar-fixed.js"></script>
        <script src="js/inicioRepresentante.js"></script>
        <script src="js/PerfilRepresentante.js"></script>
        <script language="javascript" type="text/javascript" src="plugins/lobibox/js/lobibox.min.js"></script>
        <script type="text/javascript" src="plugins/form-validator/jquery.form-validator.min.js"></script>

    </head>

    <body>
        <nav class="navbar navbar-toggleable-sm fixed-top bg-primary navbar-inverse">
          <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
           </button>

            <a class="navbar-brand" href="#">
                <img src="images/logoescom(1).png" height="50">
            </a>
          <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link active" href="index.html">Inicio</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="index.html">Cerrar Sesión</a>
              </li>
            </ul>
          </div>
        </nav>

        <div class="container-fluid section bg-primary" style="height: 15%; margin-top: 74px;" id="about">
          <div class="container text-center">
            <div class="row align-items-center">
              <div class="col-lg-12">
                <h1 class="text-light">Liga de f&uacute;tbol ESCOM-IPN <i class="fa fa-futbol-o fa-1x" aria-hidden="true"></i></h1>
              </div>
            </div>
          </div>
        </div>
        <div class="container-fluid section" id="section1">
          <div class="container">
            <div class="row">
              <div class="col-lg-12">
                <center><br><h1 class="text-light">Bienvenido Representante</h1></center>
                 <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                      <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#inicio" role="tab">Principal</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#gestionar" role="tab">Gestionar Equipos</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#perfil" role="tab">Perfil</a>
                      </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                      <div class="tab-pane active" id="inicio" role="tabpanel">
                          Pantalla inicio representante 1
                      </div>
                      <div class="tab-pane" id="gestionar" role="tabpanel">
                       <br><h2 class="text-light">Mis Jugadores <i class="fa fa-users fa-1x" aria-hidden="true"></i></h2>
                       <br>
                       <div class="row">
                          <div class="col-lg-2 col-sm-4">
                             <h6 class="fa-1x">Registrar Jugador</h6>
                          </div>
                          <div class="col-lg-1 col-sm-1">
                              <i class="fa fa-plus-square-o fa-2x registrarJugador icono" aria-hidden="true"></i>
                          </div>
                       </div>
                        <table class="table table-hover table-responsive" id="misJugadores">
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>Nombre(s)</th>
                              <th>Apellido Paterno</th>
                              <th>Apellido Materno</th>
                              <th>Correo</th>
                              <!--<th>Boleta</th>-->
                              <th>Fotograf&iacute;a</th>
                              <th>Acciones</th>
                            </tr>
                          </thead>
                          <tbody id="tablaDeJugadoresRegistrados">
                            <!--datos dinamicos-->
                          </tbody>
                        </table>
                        <br><h2 class="text-light">Mis Equipos <i class="fa fa-users fa-1x" aria-hidden="true"></i></h2>
                       <br>
                       <div class="row">
                          <div class="col-lg-2 col-sm-4">
                             <h6 class="fa-1x">Registrar Equipo</h6>
                          </div>
                          <div class="col-lg-1 col-sm-1">
                              <i class="fa fa-plus-square-o fa-2x registrarEquipo icono" aria-hidden="true"></i>
                          </div>
                       </div>
                        <table class="table table-hover table-responsive" id="misEquipos">
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>Nombre</th>
                              <th>Torneo</th>
                              <th><!-- Ver <i class="fa fa-eye fa-2x" aria-hidden="true"></i> Editar <i class="fa fa-edit fa-2x" aria-hidden="true"></i> Eliminar <i class="fa fa-close fa-2x" aria-hidden="true"></i>--></th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <th scope="row">1</th>
                              <td>Papus FC</td>
                              <td>R&aacute;pido</td>
                              <td>
                                  <i class="fa fa-eye fa-1x verPlantilla icono" aria-hidden="true" data-name="Papus FC"></i>
                                  <i class="fa fa-edit fa-1x editTeam icono" aria-hidden="true" data-name="Papus FC"></i>
                                  <i class="fa fa-close fa-1x deleteTeam icono" aria-hidden="true" data-name="Papus FC"></i>
                                  <i class="fa fa-print fa-1x printTeam icono" aria-hidden="true" data-name="Papus FC"></i>
                              </td>
                            </tr>
                            <tr>
                              <th scope="row">1</th>
                              <td>Papus FC</td>
                              <td>Soccer</td>
                              <td>
                                  <i class="fa fa-eye fa-1x verPlantilla icono" aria-hidden="true" data-name="Papus FC"></i>
                                  <i class="fa fa-edit fa-1x editTeam icono" aria-hidden="true" data-name="Papus FC"></i>
                                  <i class="fa fa-close fa-1x deleteTeam icono" aria-hidden="true" data-name="Papus FC">
                                  <i class="fa fa-print fa-1x printTeam icono" aria-hidden="true" data-name="Papus FC"></i>
                                  </i>
                              </td>
                            </tr>

                          </tbody>
                        </table>
                      </div>
                      <div class="tab-pane" id="perfil" role="tabpanel">
                          <br><h2 class="text-light">Datos del Perfil <i class="fa fa-user fa-1x" aria-hidden="true"></i></h2>
                          <br>
                          <table class="table table-hover table-responsive">
                          <thead>
                            <tr>
                              <th>Nombre(s)</th>
                              <th>Apellido Paterno</th>
                              <th>Apellido Materno</th>
                              <th>Correo</th>
                              <th>Fotograf&iacute;a</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>Mark1</td>
                              <td>Otto</td>
                              <td>Otto</td>
                              <td>@mdo</td>
                              <td>Foto</td>
                            </tr>
                          </tbody>
                        </table>
                          <br>
                          <a class="btn btn-secondary">Actualizar Informaci&oacute;n <i class="fa fa-edit fa-1x editarDatosPerfil icono" aria-hidden="true" data-name="Papus FC"></i></a>
                      </div>
                    </div>
              </div>
            </div>
          </div>
        </div>
        <!-- modales -->

        <!-- modal Ver Plantilla-->
        <div class="modal fade" id="modalVerP" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Plantilla Actual</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
                <div class="form-group">
                      <table class="table table-hover table-responsive" id="jugadores">
                          <thead>
                            <tr>
                              <th>Jugador</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>Mark1</td>
                            </tr>
                            <tr>
                              <td>Mark2</td>
                            </tr>
                          </tbody>
                        </table>
                    </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                  </div>
              </div>
            </div>
          </div>

        <!-- modal Registrar-->
        <div class="modal fade" id="modalRegistrar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar a un nuevo jugador</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form id="formularioRegistrarJugador">
                  <div class="form-group">
                    <label for="nombre">Nombre(s)</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" data-validation="custom" data-validation-regexp="^[a-zA-Z][a-zA-Z ]*$">
                  </div>
                  <div class="form-group">
                    <label for="apellidoPaterno">Apellido Paterno</label>
                    <input type="text" class="form-control" id="apellidoPaterno" name="apellidoPaterno" data-validation="custom" data-validation-regexp="^[a-zA-Z][a-zA-Z ]*$">
                  </div>
                  <div class="form-group">
                    <label for="apellidoMaterno">Apellido Materno</label>
                    <input type="text" class="form-control" id="appelidoMaterno" name="apellidoMaterno" data-validation="custom" data-validation-regexp="^[a-zA-Z][a-zA-Z ]*$">
                  </div>
                  <div class="form-group">
                    <label for="correo">Correo</label>
                    <input class="form-control" id="correo" placeholder="correo@ejemplo.com" data-validation="required email" name="correo">
                  </div>
                  <div class="form-group">
                    <label for="telefono">Tel&eacute;fono</label>
                    <input type="text" class="form-control" id="telefono" placeholder="55-55-55-55-55" data-validation="custom" data-validation-regexp="^\d([- ]*\d){8,12}$" data-validation-length="max20" data-validation-error-msg="El dato ingresado no es tel&eacute;fono v&aacute;lido" name="telefono">
                  </div>
                  <div class="form-group">
                    <label for="foto">Fotograf&iacute;a</label>
                    <input type="file" class="form-control-file" id="foto" name="foto" data-validation="extension required" data-validation-allowing="jpg, png, gif" data-validation-max-size="1M">
                    <small id="fileHelp" class="form-text text-muted">Subir una fotograf&iacute;a semiformal del jugador.</small>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary" id="actualizarJugador">Registrar jugador</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <!-- modal Actualizar-->
        <div class="modal fade" id="modalActualizar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Actualizar informaci&oacute;n de jugador</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form id="formularioActualizarJugador">
                  <div class="form-group">
                    <label for="nombre">Nombre completo</label>
                    <input type="text" class="form-control" id="fajNombre" name="fajNombre" disabled>
                  </div>
                  <div class="form-group">
                    <label for="correo">Correo</label>
                    <input class="form-control" id="correo" placeholder="correo@ejemplo.com" data-validation="required" data-validation="email">
                  </div>
                  <div class="form-group">
                    <label for="telefono">Tel&eacute;fono</label>
                    <input type="text" class="form-control" id="telefono" placeholder="55-55-55-55-55" data-validation="custom" data-validation-regexp="^\d([- ]*\d){8,12}$" data-validation-length="max20" data-validation-error-msg="El dato ingresado no es tel&eacute;fono v&aacute;lido">
                  </div>
                  <div class="form-group">
                    <label for="foto">Fotograf&iacute;a</label>
                    <input type="file" class="form-control-file" id="foto" data-validation="required extension" data-validation-allowing="jpg, png, gif" data-validation-max-size="1M">
                    <small id="fileHelp" class="form-text text-muted">Subir una fotograf&iacute;a semiformal del jugador.</small>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary" id="actualizarJugador">Guardar los cambios</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <!-- modal Registrar equpio-->
        <div class="modal fade" id="modalRegistrarEquipo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar equipo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form id="formularioRegistrarEquipo">
                  <div class="form-group">
                    <label for="nombreEquipo">Nombre del equipo</label>
                    <input type="text" class="form-control" id="freNombreEquipo" name="freNombreEquipo" data-validation="required">
                  </div>
                  <div class="form-group">
                    <label for="freTorneo">Plantilla del equipo</label>
                    <select class="form-control" id="freTorneo">
                      <option>Asociaci&oacute;n</option>
                      <option>R&aacute;pido</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="freColorUniforme">Color del uniforme</label>
                    <input type="text" class="form-control" id="freColorUniforme" data-validation="required" name="freColorUniforme">
                  </div>
                  <div class="form-group">
                     <label for="jugadores">Plantilla del equipo</label>
                      <table class="table table-hover table-responsive" id="elegirJugadores">
                          <thead>
                            <tr>
                              <th>Seleccionar</th>
                              <th>Jugador</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <th scope="row"><input type="checkbox" class="form-control" id="freCheck1" data-jugador="Mark1"></th>
                              <td>Mark1</td>
                            </tr>
                            <tr>
                              <th scope="row"><input type="checkbox" class="form-control" id="freCheck2" data-jugador="Mark2"></th>
                              <td>Mark2</td>
                            </tr>
                          </tbody>
                        </table>
                    </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary" id="actualizarJugador">Registrar equipo</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <!--modalDatosPerfil-->
        <div class="modal fade" id="modalDatosPerfil" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Actualizar Datos del Perfil</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              </div>
              <div class="modal-body">
                 <form id="formularioActualizarRepresentante">
                  <div class="form-group">
                    <label for="nombre">Nombre completo</label>
                    <input type="text" class="form-control" id="nombre" value="Edgar Rodrigo Arredondo Basurto" disabled>
                  </div>
                  <div class="form-group">
                    <label for="telefono">Tel&eacute;fono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" placeholder="55-55-55-55-55" data-validation="custom" data-validation-regexp="^\d([- ]*\d){8,12}$" data-validation-length="max20" data-validation-error-msg="El dato ingresado no es tel&eacute;fono v&aacute;lido">
                  </div>
                  <div class="form-group">
                    <label for="correo">Correo</label>
                    <input class="form-control" id="correo" name="correo" placeholder="correo@ejemplo.com" data-validation="required" data-validation="email">
                  </div>
                  <div class="form-group">
                    <label for="foto">Fotograf&iacute;a</label>
                    <input type="file" class="form-control-file" id="foto" name="foto" data-validation="required extension" data-validation-allowing="jpg, png, gif" data-validation-max-size="1M">
                    <small id="fileHelp" class="form-text text-muted">Subir una fotograf&iacute;a semiformal del jugador.</small>
                  </div>
                  <div class="form-group">
                    <label for="contraseña">Contraseña</label>
                    <input type="password" class="form-control" id="contraseña" name="contraseña" placeholder="contraseña" data-validation="required" >
                  </div>
                  <div class="form-group">
                    <label for="nuevacontraseña">Nueva contraseña</label>
                    <input type="password" class="form-control" id="nuevacontraseña" name="nuevacontraseña" placeholder="nuevacontraseña">
                  </div>
                  <div class="form-group">
                    <label for="nuevacontraseña1">Confirmar nueva contraseña</label>
                    <input type="password" class="form-control" id="nuevacontraseña1" name="nuevacontraseña1" placeholder="nuevacontraseña">
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary" id="actualizarJugador">Actualizar Perfil</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

    </body>
</html>