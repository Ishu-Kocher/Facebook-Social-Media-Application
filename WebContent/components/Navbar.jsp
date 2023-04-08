<!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark" id="navBar">
    <div class="container">
  <a class="navbar-brand" href="index.jsp">Facebook</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">

    <form action="UserLogin" method="post" class="form-row" id="login">

        <div class="form-group col-md-5">
          <label for="inputCity">Email address</label>
          <input type="text" name="userEmail" class="form-control" id="inputCity" required>
        </div>

        <div class="form-group col-md-5">
          <label for="inputCity">Password</label>
          <input type="password" name="userPwd" class="form-control" id="inputCity" required>
        </div>

        <div class="form-group col-md-2">
          <label for="inputCity"></label>
          <input type="submit" value="login" class="btn btn-info">
        </div>
    </form>
  </ul>
</div>
</nav>