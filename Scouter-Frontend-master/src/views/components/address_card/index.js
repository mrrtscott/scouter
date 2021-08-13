import React from 'react';


export default function AddressCard({ address }) {
    

    return (
        <div className={"mb-10"}>
            <p>{ address.streetNumber }, {address.streetName}</p>
            <p>{address.city}, {address.country}</p>
        </div>
    )

}