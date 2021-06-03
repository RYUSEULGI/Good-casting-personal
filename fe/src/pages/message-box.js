import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { messageSelector, messageList } from '../state/reducer/message.reducer';
import MessageActionType from '../utils/MessageActionType';
import PageWrapper from '../components/PageWrapper';

const MessageBox = () => {
    const dispatch = useDispatch();
    const msgList = useSelector(messageSelector).messageList;

    useEffect(() => {
        dispatch(messageList());
        console.log(msgList);

        console.log(MessageActionType[msgList[0].messageActionType]);
    }, []);

    return (
        <>
            <PageWrapper>
                <ul>
                    {msgList.map(() => {
                        return <li>{}</li>;
                    })}
                </ul>
            </PageWrapper>
        </>
    );
};

export default MessageBox;
