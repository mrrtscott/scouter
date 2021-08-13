import React, { useState } from 'react';
import Modal from '../../../../components/alert';
import { uploadDocument } from '../../../../../network';

export default function DocumentList({ jobApplication }) {
  const [uiState, setUiState] = useState({
    isUploading: false,
    uploadingComplete: false,
  });

  const applicant = jobApplication.applicant;

  const fileSelected = (e) => {
    const file = e.target.files[0];
    // uploading starts
    setUiState((prev) => ({ ...prev, isUploading: true }));

    uploadDocument(file, applicant.id, jobApplication.id)
      .then((resp) => {
        console.log(resp);
        setUiState((prev) => ({ ...prev, uploadingComplete: true }));
      })
      .catch((err) => console.log(err))

      // uploading finished
      .finally(() => {
        setUiState((prev) => ({ ...prev, isUploading: false }));
      });
  };

  return (
    <div
      className={
        uiState.isUploading
          ? 'bg-white rounded border shadow p-4 space-y-3 opacity-25 cursor-not-allowed'
          : 'bg-white rounded border shadow p-4 space-y-3'
      }
    >
      <div className="flex justify-between">
        <h2 className={'text-2xl font-semibold underline text-gray-700'}>
          Document List
        </h2>

        <form action="" className={''}>
          <label
            className={
              'text-indigo-600 border border-indigo-600 p-1 rounded mt-1 hover:bg-indigo-600 hover:text-white select-none cursor-pointer '
            }
            htmlFor={'upload_docs'}
          >
            Upload documents{' '}
          </label>

          <input
            type="file"
            className="hidden"
            id={'upload_docs'}
            onChange={fileSelected}
            disabled={uiState.isUploading}
          />
        </form>
      </div>

      <div className="flex flex-wrap gap-4">
        {jobApplication.document.map((doc, idx) => {
          return (
            <div key={idx}>
              <div className="w-24 h-24 border rounded flex items-center justify-center">
                File {idx + 1}
              </div>

              <a
                href={`https://scouter.point876solutions.com/application/download-file?path=${doc.path}&key=${doc.url}`}
              >
                <button
                  className={
                    'text-indigo-600 border border-indigo-600 p-1 rounded mt-1 w-24'
                  }
                >
                  Download
                </button>
              </a>
            </div>
          );
        })}
      </div>

      <Modal
        showModal={uiState.uploadingComplete}
        closeHandler={() =>
          setUiState({ ...uiState, uploadingComplete: false })
        }
      />
    </div>
  );
}
