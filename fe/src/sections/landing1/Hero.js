import React, { useState } from 'react';
import { Link } from 'gatsby';
import imgH from '../../assets/image/l1/png/hero-image.png';
import imgP from '../../assets/image/patterns/hero-pattern.png';
import main from '../../assets/image/main.png';
const Hero = () => {
    const userInfo =
        typeof window !== `undefined`
            ? JSON.parse(localStorage.getItem('USER'))
            : null;
    return (
        <>
            <div className="pt-26 pt-md-32 pt-lg-33 pt-xl-35 position-relative z-index-1 overflow-hidden">
                <img src={main} width="100%" />
            </div>
        </>
    );
};
export default Hero;
