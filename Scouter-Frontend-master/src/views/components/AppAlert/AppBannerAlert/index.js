import React from 'react';
import './style.css';

import { Alert } from 'react-bootstrap';

///render top level errors, warning and info as banner or modal

export const AppBannerAlert = (props) => {

    return (
        <Alert variant={props.category}>
            {props.text}
        </Alert>
    );
}