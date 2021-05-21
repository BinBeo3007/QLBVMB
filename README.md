# Đồ án Java - Quản lý bán vé máy bay
## Thành viên :
|STT  |MSSV        |      Họ và tên        |
|:---:|:----------:|-----------------------|
|1    |3119410300  |Nguyễn Hoàng Minh Thông|

### Hướng dẫn:
1) Tạo database "qlmb" và import file qlmb.sql vào SQL Sever
2) Import các thư viện liên quan trong thư mục libs
### Lưu ý:
1) Code được thực hiên trên Eclipse các phần mềm khác có thể xảy ra lỗi trên quá trình biên dịch do có sử dụng một số thư viện mặc định của Eclipse
2) Các ảnh được load trên đồ án sẽ mất vì nó được set link cứng theo máy
3) Code sử dụng sql Server để kết nối database nên nếu xữ dụng xamPP thì phải vào file: database.properties để chỉnh lại thông số phù hợp
4) Có thể có lỗi xảy ra trong quá trình biên dịch do đây là phiên bản chưa test trên máy khác
5) Có sử dụng một số thư viện mặc định của 
## Hạn chế:
1) Chưa có from đăng ký cho khách hàng
2) Chưa có tìm kiếm nâng cao

## Login:

![Alt text](hinh/login.jpg?raw=true "Form đăng nhập")

Đăng nhập tài khoản có phân biệt nhân viên và khách hàng từ đó mở ra screen phù hợp


## Screen Quản lý(admin):

![Alt text](hinh/admin/screen.jpg?raw=true "Screen quản lí")

### 1.Chức năng thống kê:

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

### 2.Chức năng quản lí khách hàng:

![Alt text](hinh/admin/khachhang.jpg?raw=true "Khách Hàng")

Bao gồm chức năng sau:
1) Xem thông tin khách hàng
2) Tìm kiếm khách hàng theo : mã khách hàng, họ, tên
3) Thêm,sửa,xóa thông tin khách hàng
4) Tạo và câp nhật mật khẩu cho tài khoản đăng nhập của khách hàng 
5) Import file excel vào để thêm dữ liệu khách hàng
6) Export file excel tất cả dữ liệu khách hàng

### 3.Chức năng quản lí nhân viên:

![Alt text](hinh/admin/nhanvien.jpg?raw=true "Nhân viên")

Bao gồm chức năng sau:
1) Xem thông tin nhân viên
2) Tìm kiếm khách hàng theo : mã nhân viên, họ, tên, mã chức vụ
3) Thêm,sửa,xóa thông tin nhân viên
4) Tạo và câp nhật mật khẩu cho nhân viên đăng nhập của khách hàng 
5) Import file excel vào để thêm dữ liệu nhân viên
6) Export file excel tất cả dữ liệu nhân viên

### 4.Chức năng quản lí chuyến bay:

![Alt text](hinh/admin/chuyenbay.jpg?raw=true "Chuyến bay")

Bao gồm chức năng sau:
1) Xem thông tin chuyến bay
2) Tìm kiếm khách chuyến bay : mã chuyến bay, mã đường bay, ngày khởi hành
3) Thêm,sửa,xóa thông tin chuyến bay, khi thêm, xóa chuyến bay vé sẽ tự thêm, xóa theo chuyến  bay 
4) Xuất file pdf tất cả dữ liệu của chuyến bay

### 5.Chức năng quản lí vé:

![Alt text](hinh/admin/ve.jpg?raw=true "Vé")


