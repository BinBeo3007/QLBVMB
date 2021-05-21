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

### Chức năng thống kê:

![Alt text](hinh/admin/thongke.jpg?raw=true "Thống kê")

Bao gồm 4 bảng:
1) Bảng thống kê Doanh Thu  : thống kê tổng tiền của hóa đơn
2) Bảng thống kê Đường Bay  : thống kế số vé đã đặt của đường bay
3) Bảng thống kê Nhân Viên  : thống kê số hóa đơn mà nhân viên phụ trách
4) Bảng thống kê Khách Hàng : thống kê số vé mà khách hàng đã đặt

Có các chức năng sau:
1) Tìm kếm theo mã
2) Sắp xếp tăng dần, giảm dần
3) Xuất file pdf

### Chức năng thống kê:





