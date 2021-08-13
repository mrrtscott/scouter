import { FieldArray, Formik } from 'formik';
import React from 'react';
import { addCompany } from '../../../network';
import Nav from '../../components/Nav';

export default function AddCompanyPage() {
  const addressObject = {
    streetNumber: '',
    streetName: '',
    city: '',
    parish: '',
    county: '',
    country: 'a',
  };

  const initialValues = {
    companyName: '',
    companySize: '',
    companyAddress: [addressObject],
    taxRegistrationNumber: '',
    logo: '',
    headOfCompany: '',
    isPublicCompany: true,
    companyEstablishedDate: '',
    website: '',
    email: '',
  };

  return (
    <>
      <Nav></Nav>
      <div className={'md:container mx-auto py-8'}>
        <h2 className={'my-6 text-3xl text-gray-600 font-semibold'}>
          New Company
        </h2>

        <Formik
          initialValues={initialValues}
          onSubmit={(values) => {
            addCompany(values)
              .then((data) => {
                if (data == '') alert('Job posted sucessfully.');
              })
              .catch((err) => console.log(err));
          }}
        >
          {({ values, handleSubmit, handleChange }) => (
            <form action="" method="POST" onSubmit={handleSubmit}>
              <div className={'flex gap-2'}>
                <div className={'w-1/2 py-2'}>
                  <input
                    type="text"
                    name={`companyName`}
                    value={values.companyName}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Company Name'}
                    onChange={handleChange}
                    required
                  />
                </div>

                <div className={'w-1/2 py-2'}>
                  <select
                    name={`companySize`}
                    value={values.companySize}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Company Size'}
                    onChange={handleChange}
                  >
                    <option value="#">Select One</option>
                    <option value="MICRO">Micro</option>
                    <option value="SMALL">Small</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="LARGE">Large</option>
                  </select>
                </div>
              </div>

              <div className={'flex gap-2'}>
                <div className={'w-1/2 py-2'}>
                  <input
                    type="text"
                    name={`taxRegistrationNumber`}
                    value={values.taxRegistrationNumber}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Tax Registration Number'}
                    onChange={handleChange}
                  />
                </div>

                <div className={'w-1/2 py-2'}>
                  <input
                    type="text"
                    name={`logo`}
                    value={values.logo}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Company Logo'}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>

              <div className={'flex gap-2'}>
                <div className={'w-1/2 py-2'}>
                  <input
                    type="text"
                    name={`headOfCompany`}
                    value={values.headOfCompany}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Company Head'}
                    onChange={handleChange}
                    required
                  />
                </div>

                <div className={'w-1/2 py-2'}>
                  <input
                    type="date"
                    name={`companyEstablishedDate`}
                    value={values.companyEstablishedDate}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Company Established Date'}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>

              <div className={'flex gap-2'}>
                <div className={'w-1/2 py-2'}>
                  <input
                    type="text"
                    name={`website`}
                    value={values.website}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Company Website'}
                    onChange={handleChange}
                    required
                  />
                </div>

                <div className={'w-1/2 py-2'}>
                  <input
                    type="text"
                    name={`email`}
                    value={values.email}
                    className={'p-2 border rounded w-full'}
                    placeholder={'Company Email'}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>

              <div className={'flex gap-2'}>
                <input
                  type="checkbox"
                  name={`isPublicCompany`}
                  value={values.isPublicCompany}
                  className={'p-2 border rounded mr-3'}
                  onChange={handleChange}
                  id={'isPublicCompany'}
                  required
                />
                <label htmlFor="isPublicCompany">isPublicCompany</label>
              </div>

              <FieldArray name={'companyAddress'}>
                {({ push, insert, remove }) => (
                  <>
                    <div className={'flex space-between '}>
                      <h2
                        className={'text-3xl font-semibold text-gray-600 mt-6'}
                      >
                        Addresses
                      </h2>

                      <button
                        type="button"
                        className={
                          'ml-auto bg-indigo-600 hover:bg-indigo-700 p-2 text-white rounded shadow mb-3 mt-8 px-3'
                        }
                        onClick={() => push(addressObject)}
                      >
                        New +
                      </button>
                    </div>
                    <div className={'flex gap-2 flex-wrap'}>
                      {values.companyAddress.length > 0 &&
                        values.companyAddress.map((address, idx) => (
                          <div
                            className={
                              'bg-white p-6 flex flex-col gap-2 w-96 border-2 border-dashed'
                            }
                            key={idx}
                          >
                            <input
                              type="text"
                              name={`companyAddress.${idx}.streetName`}
                              value={address.streetName}
                              onChange={handleChange}
                              placeholder={'Street Name'}
                              className={'p-2 rounded border'}
                              required
                            />

                            <input
                              type="text"
                              name={`companyAddress.${idx}.streetNumber`}
                              value={address.streetNumber}
                              onChange={handleChange}
                              placeholder={'Street Number'}
                              className={'p-2 rounded border'}
                              required
                            />

                            <input
                              type="text"
                              name={`companyAddress.${idx}.city`}
                              value={address.city}
                              onChange={handleChange}
                              placeholder={'City'}
                              className={'p-2 rounded border'}
                              required
                            />

                            <input
                              type="text"
                              name={`companyAddress.${idx}.parish`}
                              value={address.parish}
                              onChange={handleChange}
                              placeholder={'Parish'}
                              className={'p-2 rounded border'}
                              required
                            />

                            <input
                              type="text"
                              name={`companyAddress.${idx}.county`}
                              value={address.county}
                              onChange={handleChange}
                              placeholder={'County'}
                              className={'p-2 rounded border'}
                              required
                            />

                            <input
                              type="text"
                              name={`companyAddress.${idx}.country`}
                              value={address.country}
                              onChange={handleChange}
                              placeholder={'Country'}
                              className={'p-2 rounded border'}
                              required
                            />
                          </div>
                        ))}
                    </div>
                  </>
                )}
              </FieldArray>

              {/* <pre>{JSON.stringify(values, null, 2)}</pre> */}

              <button
                type={'submit'}
                className={
                  'p-2 px-4 bg-green-600 hover:bg-green-700 text-white rounded shadow-lg hover:shadow'
                }
              >
                Submit
              </button>
            </form>
          )}
        </Formik>
      </div>
    </>
  );
}
