1.	Giới thiệu
1.1.	Mục tiêu: 
Mục tiêu của ứng dụng là xây dựng web với giao diện đơn giản dễ sử dụng, hỗ trợ các công ty trong việc quản lý quá trình tuyển dụng, tìm kiếm ứng viên phù hợp, đồng thời giúp ứng viên tìm kiếm và ứng tuyển các cơ hội việc làm hiệu quả.
1.2.	Công nghệ sử dụng:
-	Backend:
+ Framework: Spring Boot.
+ Cơ sở dữ liệu: MariaDB.
+ ORM: Spring Data JPA.
+ Spring Mail
-	Frontend:
+ Template engine: Thymeleaf.
+ Thư viện giao diện: Bootstrap.
-	Thư viện hỗ trợ com.neovisionaries: Xử lý mã quốc gia.
1.3.	Các chức năng chính:
-	Đối với công ty:
+ Hiển thị danh sách công việc của tài khoàn đó khi đăng nhập vào.
+ Cho phép công ty đăng tin tuyển người với các skill mong muốn
+ Hiển thị danh sách ứng viên có skill phù hợp với skill của job.
+ Hỗ trợ gửi mail mời làm việc đến ứng viên phù hợp.
-	Đối với ứng viên:
+ Các ứng viên khi log vào sẽ được gợi ý các công việc có skill phù hợp với mình
+ Đề xuất các skill mà ứng viên chưa có trong job để học 
