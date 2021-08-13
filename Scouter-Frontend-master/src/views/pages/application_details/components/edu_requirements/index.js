import React from "react";

export default function EduRequirements({job}) {
    return (
        <div className={"bg-white rounded border p-4 space-y-3"}>
            <h2 className={"text-2xl font-semibold text-gray-700 underline"}>
                Education Requirements
            </h2>

            {job.educationRequirements.map((req) => {
                return (
                    <div key={req.id}>
                        <div className={"text-gray-600 my-3"}>
                            <h3 className={"font-semibold"}>Description</h3>
                            <p>{req.description}</p>
                        </div>

                        <div className={"text-gray-600 my-3"}>
                            <h3 className={"font-semibold"}>
                                Required Attainment
                            </h3>
                            <p>{req.requiredAttainment}</p>
                        </div>
                    </div>
                );
            })}
        </div>
    );
}
