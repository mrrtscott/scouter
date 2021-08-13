import React from "react";

export default function ApplicationDetails({jobApplication }) {
    return (
        <div className={"bg-white p-4 shadow rounded"}>
            <h2 className={"text-2xl font-semibold text-gray-700 underline"}>
                Application Details
            </h2>

            <div className={"mt-3"}>
                <p className={"text-gray-600 font-semibold"}>
                    Created At:
                    <span className={"font-normal ml-3"}>
                        {jobApplication.dateCreated}
                    </span>
                </p>

                <p className={"text-gray-600 font-semibold"}>
                    Updated At:
                    <span className={"font-normal ml-3"}>
                        {jobApplication.dateUpdated}
                    </span>
                </p>

                <p className={"text-gray-600 font-semibold"}>
                    Status:
                    <span className={"font-normal ml-3"}>
                        {jobApplication.status}
                    </span>
                </p>

                <p className={"text-gray-600 font-semibold"}>
                    Score:
                    <span className={"font-normal ml-3"}>
                        {jobApplication.score}
                    </span>
                </p>
            </div>
        </div>
    );
}
