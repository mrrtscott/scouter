import React from "react";

export default function Stages({ job, jobApplication }) {
    return (
        <div className={"bg-white p-4 shadow rounded space-y-3"}>
            <h2 className={"text-2xl font-semibold text-gray-700 underline"}>
                Stages
            </h2>

            <div className={"flex flex-wrap gap-1"}>
                {job.stages.map((stage, idx) => {
                    const styles =
                        stage.stageName === jobApplication.currentStage
                            ? "border-green-400 text-green-500"
                            : "";
                    return (
                        <div
                            className={`flex flex-col items-center border-2 p-2 rounded ${styles}`}
                            key={idx}
                        >
                            <p className={"text-sm font-semibold"}>
                                {stage.stageName}
                            </p>
                        </div>
                    );
                })}
            </div>

            
            <h2 className={"text-lg font-semibold text-gray-600"}>Stages Information</h2>
            <table className={"table-auto border border-collapse text-gray-600"}>
                <thead>
                <tr>
                    <th className={"border p-1"}>Name</th>
                    <th className={"border p-1"}>Description</th>
                </tr>
                </thead>

                <tbody>
                    
                {job.stages.map((stage, idx) => {
                    return <tr key={idx}>
                        <td className={"border p-1 font-semibold text-sm"}>{stage.stageName}</td>
                        <td className={"border p-1"}>{stage.stageDescription}</td>
                    </tr>;
                })}
                    
                    </tbody>
            </table>
        </div>
    );
}
