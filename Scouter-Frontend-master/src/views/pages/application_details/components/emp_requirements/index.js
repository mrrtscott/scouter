import React from "react";

export default function EmploymentRequirements({job}) {
    return (
        <div className={"bg-white rounded border p-4 space-y-3"}>
            <h2 className={"text-2xl font-semibold text-gray-700 underline"}>
                Employment Requirements
            </h2>

            {job.employmentRequirements.map((req) => {
                return (
                    <div key={req.id}>
                        <div className={"text-gray-600 my-3"}>
                            <h3 className={"font-semibold"}>
                                Min Years Experience
                            </h3>
                            <p>{req.minYearsExperience}</p>
                        </div>

                        <div className={"text-gray-600 my-3"}>
                            <h3 className={"font-semibold"}>
                                Experience Position
                            </h3>
                            <p>{req.experiencePosition}</p>
                        </div>
                    </div>
                );
            })}
        </div>
    );
}
