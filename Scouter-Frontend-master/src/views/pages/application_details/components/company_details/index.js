import React from "react";

export default function CompanyDetails({ company, address }) {
    return (
        <div className="bg-white rounded border p-4 flex items-center gap-4">
            <div className={"w-40 h-40 flex items-center shadow p-2 rounded"}>
                <img src={`${company.logo}`} alt="" />
            </div>

            <div className={"space-y-2"}>
                <p className={"text-lg font-semibold text-gray-700"}>
                    {company.companyName}
                </p>

                <div>
                    
                    <p>
                        {address.streetNumber} {address.streetName},{" "}
                        {address.county}, {address.country}
                    </p>
                </div>
                <p>
                    <a href={`${company.website}`} className={"text-blue-600"}>
                        {company.website}
                    </a>
                </p>
            </div>
        </div>
    );
}
