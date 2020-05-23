<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>

</head>

<body>
  <!-- NavBar -->
  <div style="color: white;">
    <nav class="navbar navbar-dark btn-primary">
      <a class="navbar-brand">Think Code</a>
      <form class="form-inline" method="POST" action="LoginServlet">
        <button class="btn btn-warning" type="submit" style="color: white;">Sistema</button></a
      </form>
    </nav>
  </div>
  <!-- NavBar -->
  <br>
  <!-- Parte 1 -->

  <div class="jumbotron jumbotron-fluid">
    <div class="container">
      <h1 class="display-4" style="text-align: center;">THINK CODE</h1>
      <p class="lead" style="text-align: center;">Seja Bem vindo a Tink Code, se voce procura peças automobilistica,
        voce esta no lugar certo</p>
    </div>
  </div>

  <!--/ Parte 1 -->

  <div style="text-align: center;">
    <h3>Sobre nos </h3>
  </div>
  <hr>

  <!-- Parte 2 -->
  <div>
    <div class="card" style="width:50%; ;">
      <div style="width: -90%;;">
        <img class="card-img-top" src="img/imgHistoria.jpg">
      </div>
      <div class="card-body">
        <p class="card-text">Fundada em fevereiro de 2000, Tink Code vem obtendo um crescimento grande na aréa de vendas
          e distribuição por todo território nacional. Empresa conta com grandes parceiros do ramo de fabricação e
          transporte de peças e derivados.<br>
          Para melhoria de atendimento e suporte aos clientes e colaboradores a Think Code possui escritórios esaplhados
          pelas 4 regiões brasileira, tendo sua matriz localizada em São Paulo.</p>
      </div>
    </div>
  </div>
  <div style="margin-left: 30%; margin-top: -40.5%">
    <div style="width: 70%;  margin-left: 30%; ">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block w-100" src="img/img04.jpg" alt="Primeiro Slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/img02.png" alt="Segundo Slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/img04.jpg" alt="Terceiro Slide">
          </div>
        </div>
      </div>
    </div>

    <!--/Parte 2 -->

    <div style="margin-top: 22%;">
      <h3 style="margin-left: 20%;"> Produtos </h3>
    </div>
    <hr>

    <!-- Parte 3 -->
    <div style="margin-left: -40%;">
      <div class="card-columns">
        <div class="card">
          <img class="card-img-top" src="img/Prod01.jpg" alt="Imagem de capa do card">
          <div class="card-body">
            <h5 class="card-title">Ferramentas para Mecanica</h5>
          </div>
        </div>
        <div class="card p-3">
          <blockquote class="blockquote mb-0 card-body">
            <footer class="blockquote-footer">
              <small class="text-muted">
                Alguém famoso em <cite title="Título da fonte">Título da fonte</cite>
              </small>
            </footer>
          </blockquote>
        </div>
        <div class="card">
          <img class="card-img-top" src="img/Prod04.jpg" alt="Imagem de capa do card">
          <div class="card-body">
            <h5 class="card-title">Capôs, Portas etc...</h5>
            <p class="card-text"><small class="text-muted">Depósito São Paulo</small></p>
          </div>
        </div>
        <div class="card">
          <img class="card-img-top" src="img/Prod03.jpg" alt="Imagem de capa do card">
          <div class="card-body">
            <h5 class="card-title">Calotas parafusos porcas...</h5>
            <p class="card-text"><small class="text-muted">Atualizados 3 minutos atrás</small></p>
          </div>
        </div>
        <div class="card text-center">
          <div class="card-body">
            <h5 class="card-title">Oléos, Fluidos de Freios...</h5>
            <p class="card-text">
            <div>

            </div>
            </p>
            <p class="card-text"><small class="text-muted">Atualizados 3 minutos atrás</small></p>
          </div>
        </div>
        <div class="card">
          <img class="card-img-top" src="img/Prod02.jpg" alt="Imagem de capa do card">
          <div class="card-body">
            <h5 class="card-title">Calotas parafusos porcas...</h5>
            <p class="card-text"><small class="text-muted">Atualizados 3 minutos atrás</small></p>
          </div>
        </div>
        <div class="card">
          <img class="card-img" src="img/img01.jpg" alt="Imagem do card">
        </div>
        <div class="card p-3 text-right">
          <blockquote class="blockquote mb-0">
            <p></p>
            <footer class="blockquote-footer">
              <small class="text-muted">
                Depósito <cite title="Título da fonte">Manaus</cite>
              </small>
            </footer>
          </blockquote>
        </div>
      </div>
      <hr>
    </div>

    <!--/ Parte 3 -->

    <div style="margin-top: 2%;">
      <h3 style="margin-left: 20%;"> FeedBack </h3>
    </div>

    <!-- Parte 4 -->
    <div style="margin-left: -40%;">
      <div class="grey">
        <div class="container pt ">
          <div class="row mt centered">
            <div class="col-lg-3">
              <span class="glyphicon glyphicon-book"></span>
            </div>

            <div class="col-lg-3" style="margin-left: -10%;">
              <span class="glyphicon glyphicon-user"></span>
              <p>Visão<br>
                Exelente o Atendimento! Adorei !!</p>
            </div>

            <div class="col-lg-3">
              <span class="glyphicon glyphicon-fire"></span>

            </div>

            <div class="col-lg-3">
              <span class="glyphicon glyphicon-globe"></span>

            </div>
          </div>
          <!-- /row -->

          <div class="row mt">
            <div class="col-lg-6">
              <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" style="width: 40%;">
                  <div class="carousel-item active">
                    <img class="d-block w-100" src="http://www.wowthemes.net/demo/calypso/img/demo/team1.jpg"
                      alt="Primeiro Slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="http://www.wowthemes.net/demo/calypso/img/demo/team2.jpg"
                      alt="Segundo Slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="http://www.wowthemes.net/demo/calypso/img/demo/team3.jpg"
                      alt="Terceiro Slide">
                  </div>
                </div>

              </div>
            </div>
            <!-- /colg-lg-6 -->

            <div class="col-lg-6">
              <i class="fa fa-user-circle-o" aria-hidden="true"></i>
              <h4>Feedbacks</h4> Atendimento
              <div class="progress">
                <div class="progress-bar bg-success" role="progressbar" aria-valuenow="60" aria-valuemin="0"
                  aria-valuemax="100" style="width: 60%;">
                  <span class="sr-only">6% Complete</span>
                </div>
              </div>

              Qualidade
              <div class="progress">
                <div class="progress-bar progress-bar-theme" role="progressbar" aria-valuenow="80" aria-valuemin="0"
                  aria-valuemax="100" style="width: 60%;">
                  <span class="sr-only">80% Complete</span>
                </div>
              </div>

              Voltaria a nos procurar
              <div class="progress">
                <div class="progress-bar bg-danger  " role="progressbar" aria-valuenow="95" aria-valuemin="0"
                  aria-valuemax="100" style="width: 60%;">
                  <span class="sr-only">95% Complete</span>
                </div>
              </div>

            </div>
            <!-- /col-lg-6 -->
          </div>
          <!-- /row -->
        </div>
      </div>
      <!-- +++++ Footer Section +++++ -->

      </section>
    </div>
    <br>
    <!--/ Parte 4 -->

    <!-- Parte 5 -->

    <!-- Rodape -->

    <div style="margin-left: -41%;">
      <div style="color: white;">
        <nav class="navbar navbar-dark btn-primary">
          <a><i class="fa fa-envelope-open" aria-hidden="true"></i>ThinCodePeças@outlook.com</a>
          <a><i class="fa fa-volume-control-phone" aria-hidden="true"></i> +55 115687-4877</a>
          <a class="navbar-brand"><i class="fa fa-university" aria-hidden="true"></i>São Paulo (SP)</a>
          <form class="form-inline">
          </form>
        </nav>
      </div>
    </div>
  <!-- Rodape -->
    <!--/ Parte 5 -->
</body>

</html>