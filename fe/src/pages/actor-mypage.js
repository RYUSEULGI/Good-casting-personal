import React from 'react';
import PageWrapper from '../components/PageWrapper';
import MyProfileList from '../components/Profile/MyprofileList';
import { useSelector } from 'react-redux';
import { profileSelector } from '../state/reducer/profile.reducer';

const DashboardMain = () => {
    const state = useSelector(profileSelector);

    return (
        <>
            <PageWrapper
                headerConfig={{
                    button: 'profile',
                    isFluid: true,
                    bgClass: 'bg-default',
                    reveal: false,
                }}
            >
                <div className="dashboard-main-container mt-25 mt-lg-31">
                    <div style={{ height: '100vh' }} className="container">
                        <div className="row justify-content-center">
                            {state.profile !== null ? (
                                <MyProfileList />
                            ) : (
                                <p>프로필없음</p>
                            )}
                        </div>
                    </div>
                </div>
            </PageWrapper>
        </>
    );
};
export default DashboardMain;
