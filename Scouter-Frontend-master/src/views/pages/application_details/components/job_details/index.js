import React from "react";

export default function JobDetails({job}) {
    return (
        <div className={"bg-white rounded shadow border p-4 space-y-3"}>
            <h2 className={"text-2xl font-semibold text-gray-700 underline"}>
                Job Details
            </h2>

            <div className={"text-gray-600 my-3"}>
                <h3 className={"font-semibold"}>Description</h3>
                <p>{job.description}</p>
            </div>

            <div className={"text-gray-600 my-3"}>
                <h3 className={"font-semibold"}>Position</h3>
                <p>{job.position}</p>
            </div>

            <div className={"text-gray-600 my-3"}>
                <h3 className={"font-semibold"}>Employment Type</h3>
                <p>{job.employmentType}</p>
            </div>

            <div className={"text-gray-600 my-3"}>
                <h3 className={"font-semibold"}>Duration</h3>
                <p>{job.duration}</p>
            </div>

            <div className={"text-gray-600 my-3"}>
                <h3 className={"font-semibold"}>Basic Salary</h3>
                <p>{job.basicYearlySalary}</p>
            </div>
        </div>
    );
}
