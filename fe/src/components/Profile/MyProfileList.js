import React, { useEffect } from 'react';
import { Link } from 'gatsby';
import { useSelector, useDispatch } from 'react-redux';
import {
    profileSelector,
    getMyProfileList,
} from '../../state/reducer/profile.reducer';

const MyProfileList = ({ pageResult, pageRequest }) => {
    const dispatch = useDispatch();

    const profileList = useSelector(profileSelector).profileList;

    console.log(profileList);

    useEffect(() => {
        console.log('list');
        dispatch(getMyProfileList());
    }, []);

    return (
        <>
            <div className="col-12 col-lg-6">
                {profileList.map(() => {
                    return (
                        <div className="bg-white px-8 pt-9 pb-7 rounded-4 mb-9 feature-cardOne-adjustments">
                            <div className="d-block mb-7">
                                <Link to="/#">
                                    {/* <img src={imgB1} alt="" /> */}
                                </Link>
                            </div>
                            <Link
                                to="/#"
                                className="font-size-3 d-block mb-0 text-gray"
                            >
                                {profileList.id}
                            </Link>
                            <h2 className="mt-n4">
                                <Link
                                    to="/#"
                                    className="font-size-7 text-black-2 font-weight-bold mb-4"
                                >
                                    {profileList.name}
                                </Link>
                            </h2>
                            <div className="card-btn-group">
                                <Link
                                    to="/profile-detail"
                                    className="btn btn-green text-uppercase btn-medium rounded-3"
                                >
                                    프로필보기
                                </Link>
                            </div>
                        </div>
                    );
                })}
            </div>
        </>
    );
};

export default MyProfileList;
