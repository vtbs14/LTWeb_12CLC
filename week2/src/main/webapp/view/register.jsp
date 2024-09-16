<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<script>
	// This script will display the alert and then redirect to the login page
	function showAlertAndRedirect(message) {
		if (message) {
			alert(message);
			setTimeout(function() {
				window.location.href = "/week2/view/login.jsp";
			}, 1500); // Redirect after 1.5 second
		}
	}
</script>
</head>
<body>
	<div class="container mt-5">
		<form action="/week2/register" method="post" class="w-50 mx-auto">
			<h2 class="text-center">Tạo tài khoản mới</h2>

			<!-- Display alert message if exists -->
			<c:if test="${not empty alert}">
				<script>
					// Call the function to show the alert and redirect
					showAlertAndRedirect('${alert}');
				</script>
			</c:if>

			<section>
				<label class="input login-input">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" placeholder="Tài khoản" name="username"
							class="form-control">
					</div>
				</label>
			</section>

			<section>
				<label class="input login-input">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" placeholder="Họ tên" name="fullname"
							class="form-control">
					</div>
				</label>
			</section>

			<section>
				<label class="input login-input">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						<input type="email" placeholder="Nhập Email" name="email"
							class="form-control">
					</div>
				</label>
			</section>

			<section>
				<label class="input login-input">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-phone"></i></span>
						<input type="text" placeholder="Số điện thoại" name="phone"
							class="form-control">
					</div>
				</label>
			</section>

			<section>
				<label class="input login-input">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" placeholder="Mật khẩu" name="password"
							class="form-control">
					</div>
				</label>
			</section>

			<section>
				<label class="input login-input">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" placeholder="Nhập lại mật khẩu"
							name="confirmPassword" class="form-control">
					</div>
				</label>
			</section>

			<button type="submit" class="btn btn-primary btn-block">Tạo
				tài khoản</button>

			<p class="text-center mt-3">
				Nếu bạn đã có tài khoản? <a href="login.jsp">Đăng nhập</a>
			</p>
		</form>
	</div>
</body>
</html>