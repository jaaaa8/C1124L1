import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
// Import NavLink thay vì Link (NavLink hỗ trợ thêm class 'active' khi đang ở đúng trang đó)
import { NavLink, Link } from 'react-router-dom';

function Header() {
  return (
    <>
      {/* Đổi màu bg-dark để nhìn thanh điều hướng ngầu hơn (tùy chọn) */}
      <Navbar expand="lg" className="bg-dark navbar-dark">
      <Container>
        {/* TỐI ƯU 1: Dùng as={Link} để không bị reload trang */}
        <Navbar.Brand as={Link} to="/">Quản Lý Nhân Sự</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {/* TỐI ƯU 2: Sử dụng as={NavLink}. Nếu đang ở trang chủ, chữ "Home" sẽ tự động sáng lên */}
            <Nav.Link as={NavLink} to="/" end>Trang chủ</Nav.Link>
            
            <Nav.Link as={NavLink} to="/employee">Danh sách nhân viên</Nav.Link>
            
            {/* TỐI ƯU 3: Làm cho Dropdown trở nên có ý nghĩa với các tác vụ cụ thể */}
            <NavDropdown title="Tác vụ" id="basic-nav-dropdown">
              <NavDropdown.Item as={Link} to="/employee/add">
                Thêm nhân viên mới
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item as={Link} to="/departments">
                Quản lý phòng ban
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </>
  );
}

export default Header;