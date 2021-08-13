import React from "react";
import { Link } from "react-router-dom";
import { BsCardText } from "react-icons/bs";
import { AiOutlineClockCircle,AiOutlineUser, AiOutlineRocket } from "react-icons/ai";

export default function ApplicationCard({ application }) {
    let statusStyle = "";

    switch (application.status) {
        case "OPEN":
            statusStyle = "bg-green-400";
            break;
        case "CLOSED":
            statusStyle = "bg-red-600";
            break;
        default:
            statusStyle = "bg-gray-600";
    }

    return (
        <div className={"w-80 bg-white border rounded"}>
            <div className="status relative">
                <p
                    className={`text-white px-1 rounded inline-block text-sm ${statusStyle} shadow absolute right-1 top-1`}
                >
                    {application.status}
                </p>
            </div>

            <div className={"space-y-5 p-6"}>
                <div>
                    <h2
                        className={
                            "text-gray-700 font-semibold flex gap-2 items-center"
                        }
                    >
                        <span>
                            <AiOutlineUser />
                        </span>
                        Candidate:{" "}
                    </h2>
                    <p className={"text-sm text-gray-500"}>
                        {application.applicant.firstName}{" "}
                        {application.applicant.middleName}{" "}
                        {application.applicant.lastName}
                    </p>
                </div>

                <div>
                    <h2 className={"text-gray-700 font-semibold flex items-center gap-2"}>
                        <span>
                            <AiOutlineRocket />
                        </span>
                        Position:{" "}
                    </h2>
                    <p className={"text-sm text-gray-500"}>
                        {application.job.position}
                    </p>
                </div>

                <div>
                    <h2 className={"text-gray-700 font-semibold flex items-center gap-2"}>
                        <span>
                            <BsCardText />
                        </span>
                        Description:{" "}
                    </h2>
                    <p className={"text-sm text-gray-500"}>
                        {application.job.description}
                    </p>
                </div>

                <div className={"mt-4"}>
                    <div className="flex items-center gap-2">
                        <span>
                            <AiOutlineClockCircle />
                        </span>
                        <p className={"text-gray-700 font-semibold"}>
                            Created on
                        </p>
                    </div>
                    <p className={"text-gray-500 text-sm"}>20-02-2021</p>
                </div>

                <div className={"mt-4"}>
                    <div className="flex items-center gap-2">
                        <span>
                            <AiOutlineClockCircle />
                        </span>
                        <p className={"text-gray-700 font-semibold"}>
                            Updated on
                        </p>
                    </div>
                    <p className={"text-gray-500 text-sm"}>20-02-2021</p>
                </div>

                <div className="flex justify-between items-center">
                    <Link
                        to={`/application-details/${application.id}`}
                        className={
                            "block w-full p-2 rounded shadow text-white text-center bg-indigo-600 hover:bg-indigo-700"
                        }
                    >
                        More Details
                    </Link>
                </div>
            </div>
        </div>
    );
}
