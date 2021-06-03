import React, { useContext } from 'react';
import { Link } from 'gatsby';
import { Collapse } from 'react-bootstrap';
import GlobalContext from '../../context/GlobalContext';
import imgL from '../../assets/image/logo-main-black.png';
import MailOutline from '@material-ui/icons/MailOutline';
const Sidebar = () => {
    const gContext = useContext(GlobalContext);

    return (
        <>
            <Collapse in={gContext.showSidebarDashboard}>
                <div className="dashboard-sidebar-wrapper pt-11" id="sidebar">
                    <div className="brand-logo px-11">
                        <Link to="/">
                            <img src={imgL} alt="" />
                        </Link>
                    </div>
                    <div className="my-15 px-11">
                        <Link
                            to="/hire-register"
                            className="btn btn-primary btn-xl w-100 text-uppercase"
                        >
                            <span className="mr-5 d-inline-block">+</span>공고
                            등록하기
                        </Link>
                    </div>
                    <ul className="list-unstyled dashboard-layout-sidebar">
                        <li className="">
                            <Link
                                activeClassName="active"
                                to="/dashboard"
                                className="px-10 py-1 my-5 font-size-4 font-weight-semibold flex-y-center"
                            >
                                <i className="icon icon-layout-11 mr-7"></i>
                                메인
                            </Link>
                        </li>
                        <li className="">
                            <Link
                                to="/dashboard-hires"
                                activeClassName="active"
                                className="px-10 py-1 my-5 font-size-4 font-weight-semibold flex-y-center"
                            >
                                <i className="fas fa-briefcase mr-7"></i>
                                업로드리스트
                            </Link>
                        </li>
                        <li className="">
                            <Link
                                to="/dashboard-applicants"
                                activeClassName="active"
                                className="px-10 py-1 my-5 font-size-4 font-weight-semibold flex-y-center"
                            >
                                <i className="fas fa-user mr-7"></i>지원자리스트
                                <span className="ml-auto px-1 h-1 bg-dodger text-white font-size-3 rounded-5 max-height-px-18 flex-all-center">
                                    14
                                </span>
                            </Link>
                        </li>
                        <li className="">
                            <Link
                                to="/dashboard-contact"
                                activeClassName="active"
                                className="px-10 py-1 my-5 font-size-4 font-weight-semibold flex-y-center"
                            >
                                <MailOutline />
                                메시지함
                            </Link>
                        </li>
                        <li className="">
                            <Link
                                to="/dashboard-settings"
                                activeClassName="active"
                                className="px-10 py-1 my-5 font-size-4 font-weight-semibold flex-y-center"
                            >
                                <i className="fas fa-cog mr-7"></i>정보수정
                            </Link>
                        </li>
                    </ul>
                </div>
            </Collapse>
            <a
                href="/#"
                className="sidebar-mobile-button"
                onClick={(e) => {
                    e.preventDefault();
                    gContext.toggleSidebarDashboard();
                }}
            >
                <i className="icon icon-sidebar-2"></i>
            </a>
        </>
    );
};

export default Sidebar;
