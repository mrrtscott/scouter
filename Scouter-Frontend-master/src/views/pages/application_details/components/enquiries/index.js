import React from "react";

export default function Enquiries({jobApplication}) {
    return (
        <div className={"bg-white p-4 shadow rounded space-y-3"}>
            <h2 className={"text-gray-700 font-semibold text-2xl underline"}>
                Enquiries
            </h2>

            {jobApplication.enquiry.map((enq, idx) => {
                return (
                    <div className={"space-y-3"} key={idx}>
                        <div>
                            <h2
                                className={
                                    "text-lg font-semibold text-gray-700"
                                }
                            >
                                Title
                            </h2>
                            <p>{enq.title}</p>
                        </div>

                        <div>
                            <h2
                                className={
                                    "text-lg font-semibold text-gray-700"
                                }
                            >
                                Question
                            </h2>
                            <p>{enq.question}</p>
                        </div>

                        <div>
                            <h2
                                className={
                                    "text-lg font-semibold text-gray-700"
                                }
                            >
                                Response
                            </h2>
                            <p>{enq.response || "No response"}</p>
                        </div>

                        <div>
                            <h2
                                className={
                                    "text-lg font-semibold text-gray-700"
                                }
                            >
                                Status
                            </h2>
                            <p>{enq.status}</p>
                        </div>

                        <div>
                            <h2
                                className={
                                    "text-lg font-semibold text-gray-700"
                                }
                            >
                                Created at
                            </h2>
                            <p>{enq.createdAt}</p>
                        </div>
                    </div>
                );
            })}
        </div>
    );
}
