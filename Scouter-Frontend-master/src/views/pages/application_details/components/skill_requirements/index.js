import React from "react";

export default function SkillRequirements({job}) {
    return (
        <div className={"bg-white rounded border p-4 space-y-3"}>
            <h2 className={"text-2xl font-semibold text-gray-700 underline"}>
                Skill Requirements
            </h2>

            {job.skillRequirements.map((req) => {
                return (
                    <div key={req.id} className={"border p-4 rounded"}>
                        <div className={"text-gray-600 my-3"}>
                            <h3 className={"font-semibold"}>Description</h3>
                            <p>{req.description}</p>
                        </div>

                        <div className={"text-gray-600 my-3"}>
                            <h3 className={"font-semibold"}>Skill</h3>
                            <p>{req.skill}</p>
                        </div>

                        <div className={"text-gray-600 my-3"}>
                            <input
                                type="checkbox"
                                checked={req.isRequired}
                                onChange={() => {}}
                            />

                            <span className={"ml-2 font-semibold"}>
                                Required
                            </span>
                        </div>
                    </div>
                );
            })}
        </div>
    );
}
