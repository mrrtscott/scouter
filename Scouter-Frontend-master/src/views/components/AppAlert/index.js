import React from 'react';
import './style.css';
import AppBannerAlert from './AppBannerAlert/index';
import AppModalAlert from './AppModalAlert/index';
import noop from 'lodash-es/noop';

///render top level errors, warning and info as banner or modal

export const AppAlert = (props) => {

    return props.type === 'banner' ?
        (
            <AppBannerAlert
                text={props.alertProps.text}
                category={props.alertProps.category}
            />
        )
        :
        (
            <AppModalAlert
                title={props.alertProps.title}
                text={props.alertProps.title}
                category={props.alertProps.category}
                posActionLabel={props.alertProps.posActionLabel ?? ''}
                posAction={props.alertProps.posAction ?? noop}
                negActionLabel={props.alertProps.negActionLabel ?? ''}
                negAction={props.alertProps.negAction ?? noop}
            />
        );
}