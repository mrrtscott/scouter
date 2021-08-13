import React, { useState } from 'react';
import './style.css';

export const InputField = ({
    fieldName,
    fieldType,
    ...props
}) => {

    const [error, setError] = useState({
        errorState: false,
        errorMessage: "Invalid Input"
    });

    const [fieldValue, setFieldValue] = useState('');

    const validateFieldValue = (value) => {
        if 
    }

    return (
        <div>
            <input type={fieldType} label={fieldName} name={fieldName} value={fieldValue} required={props.required ?? false} onChange={validateFieldValue(this.value, this.type)} />
            {error.errorState ?
                <div class="input-field-error">{error.errorMessage}</div>
                :
                <div></div>
            }
        </div>
    );
}