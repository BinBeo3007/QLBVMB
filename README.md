# Đồ án Java - Quản lý bán vé máy bay
### Hướng dẫn:
1) Tạo database "qlmb" và import file qlmb.sql vào SQL Sever
2) Import các thư viện liên quan trong thư mục libs
### Lưu ý:
1) Code được thực hiên trên Eclipse các phần mềm khác có thể xảy ra lỗi trên quá trình biên dịch do có sử dụng một số thư viện mặc định của Eclipse
2) Các ảnh được load trên đồ án sẽ mất vì nó được set link cứng theo máy
3) Code sử dụng sql Server để kết nối database nên nếu xữ dụng xamPP thì phải vào file: database.properties để chỉnh lại thông số phù hợp
4) Có thể có lỗi xảy ra trong quá trình biên dịch do đây là phiên bản chưa test trên máy khác
## Hạn chế:
1) Chưa có from đăng ký cho khách hàng
2) Chưa có tìm kiếm nâng cao

## Login:

![Alt text](hinh/login.jpg?raw=true "Form đăng nhập")

Đăng nhập tài khoản có phân biệt nhân viên và khách hàng từ đó mở ra screen phù hợp


## Screen Quản lý(admin):

![Alt text](hinh/admin/screen.jpg?raw=true "Screen quản lí")

### 1. Chức năng thống kê:

![Alt text](hinh/admin/thongke.jpg?raw=true "Thống kê")

Bao gồm 4 bảng:
1) Bảng thống kê Doanh Thu  : thống kê tổng tiền của hóa đơn
2) Bảng thống kê Đường Bay  : thống kế số vé đã đặt của đường bay
3) Bảng thống kê Nhân Viên  : thống kê số hóa đơn mà nhân viên phụ trách
4) Bảng thống kê Khách Hàng : thống kê số vé mà khách hàng đã đặt

Bao gồm chức năng sau:
1) Tìm kếm theo mã
2) Sắp xếp tăng dần, giảm dần
3) Xuất file pdf

### 2. Chức năng quản lí khách hàng:

![Alt text](hinh/admin/khachhang.jpg?raw=true "Khách Hàng")

Bao gồm chức năng sau:
1) Xem thông tin khách hàng
2) Tìm kiếm khách hàng theo : mã khách hàng, họ, tên
3) Thêm,sửa,xóa thông tin khách hàng
4) Tạo và câp nhật mật khẩu cho tài khoản đăng nhập của khách hàng 
5) Import file excel vào để thêm dữ liệu khách hàng
6) Export file excel tất cả dữ liệu khách hàng

### 3. Chức năng quản lí nhân viên:

![Alt text](hinh/admin/nhanvien.jpg?raw=true "Nhân viên")

Bao gồm chức năng sau:
1) Xem thông tin nhân viên
2) Tìm kiếm nhân viên theo : mã nhân viên, họ, tên, mã chức vụ
3) Thêm,sửa,xóa thông tin nhân viên
4) Tạo và câp nhật mật khẩu cho nhân viên đăng nhập của nhân viên
5) Import file excel vào để thêm dữ liệu nhân viên
6) Export file excel tất cả dữ liệu nhân viên

### 4.Chức năng quản lí chuyến bay:

![Alt text](hinh/admin/chuyenbay.jpg?raw=true "Chuyến bay")

Bao gồm chức năng sau:
1) Xem thông tin chuyến bay
2) Tìm kiếm chuyến bay theo: mã chuyến bay, mã đường bay, ngày khởi hành
3) Thêm,sửa,xóa thông tin chuyến bay, khi thêm, xóa chuyến bay vé sẽ tự thêm, xóa theo chuyến  bay 
4) Xuất file pdf tất cả dữ liệu của chuyến bay

### 5.Chức năng quản lí vé:

![Alt text](hinh/admin/ve.jpg?raw=true "Vé")

Bao gồm chức năng sau:
1) Xem thông tin vé
2) Tìm kiếm vé theo : mã vé, mã khách hàng, mã chuyến bay
3) Cập nhật thông tin vé(mã khách hàng, ngày đặt vé)
4) Xóa vé
 
 ### 6.Chức năng quản lí hóa đơn:
 
 ![Alt text](hinh/admin/hoadoon.jpg?raw=true "Hóa đơn")
 
Bao gồm chức năng sau:
1) Xem thông tin hóa đơn và chi tiết hóa đơn
2) Tìm kiếm vé theo : mã hóa đơn, mã khách hàng, đã thanh toán, thanh toán
3) Cập nhật thông tin hóa đơn(mã nhân viên, ngày thanh toán)
4) Xóa hóa đơn
5) Check hóa đơn: để đổi tình trạng hóa đơn chưa thanh toán thành đã thanh toán
6) Tính tiền : tính tổng tiền hóa đơn nếu nhập mã khuyến mãi chính xác thì sẽ được giảm giá theo mã khuyến mãi

 ### 7.Chức năng quản lí khuyến mãi:
 
  ![Alt text](hinh/admin/khuyenmai.jpg?raw=true "Khuyến Mãi")
 
 Bao gồm chức năng sau:
1) Xem thông tin khuyến mãi
2) Tìm kiếm khuyến mãi theo mã khuyến mãi
3) Thêm,sửa,xóa thông tin khuyến mãi


 ### 8.Chức năng quản lí máy bay:
 
  ![Alt text](hinh/admin/maybay.jpg?raw=true "Máy Bay")
 
 Bao gồm chức năng sau:
1) Xem thông tin máy bay
2) Tìm kiếm khuyến mãi theo: mã máy bay, hảng sản xuất, tổng ghế
3) Thêm thông tin máy bay

 ### 9.Chức năng quản lí đường bay:
 
  ![Alt text](hinh/admin/duongbay.jpg?raw=true "Đường bay")
 
 Bao gồm chức năng sau:
1) Xem thông tin đường bay
2) Tìm kiếm khuyến mãi theo mã mã đường bay
3) Thêm thông tin đường bay

 ### 10.Chức năng quản lí sân bay:
 
  ![Alt text](hinh/admin/sanbay.jpg?raw=true "Sân bay")
 
 Bao gồm chức năng sau:
1) Xem thông tin sân bay
2) Tìm kiếm khuyến mãi theo mã sân bay
3) Thêm thông tin sân bay

 ### 11.Chức năng quản lí địa điểm:
 
  ![Alt text](hinh/admin/điaem.jpg?raw=true "Địa điem")
 
 Bao gồm chức năng sau:
1) Xem thông tin địa điểm
2) Tìm kiếm khuyến mãi theo mã địa điểm
3) Thêm thông tin địa điểm

## Screen Khách Hàng(user):

![Alt text](hinh/user/screen.jpg?raw=true "Screen khách hàng")


### 1.Chức năng quản lí chuyến bay:

![Alt text](hinh/admin/chuyenbay.jpg?raw=true "Chuyến bay")

Bao gồm chức năng sau:
1) Xem thông tin chuyến bay
2) Tìm kiếm chuyến bay theo: mã chuyến bay, mã đường bay, ngày khởi hành

### 2.Chức năng đặt vé:

![Alt text](hinh/user/datve.jpg?raw=true "Đặt vé")

Bao gồm chức năng sau:
1) Xem thông tin chuyến bay
2) Tìm kiếm chuyến bay theo: Điểm khởi hành - Điểm đến, ngày khởi hành
3) Check: để xem giá tiền dựa trên loại vé và số lượng vé
4) Đặt vé, khi đặt vé thì hóa đơn sẽ được tạo với tình trạng chưa thanh toán

### Lời kết: Cảm ơn vì đã đọc bản báo cáo này . Chúc bạn một ngày tốt lành !!! 
### Tác giả : Nguyễn Hoàng Minh Thông

