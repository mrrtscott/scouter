import { FieldArray, Formik } from 'formik';
import React from 'react';
import { MdAddCircleOutline } from 'react-icons/md';
import { Link, useParams } from 'react-router-dom';
import { postJob } from '../../../network';
import { FaAngleLeft as Back } from 'react-icons/fa';

const stageComponentObject = {
  name: '',
  details: '',
  requiredDate: '',
  endDate: '',
};

const stageObject = {
  stageName: '',
  stageDescription: '',
  isRequired: false,
  stageComponent: [stageComponentObject],
};

export default function PostingPage() {
  const { id } = useParams();

  return (
    <div className={'container mx-auto py-6'}>
      <Link to={`/company-details/${id}`}>
        <div className="cursor-pointer flex items-center">
          <Back />
          <p>Back</p>
        </div>
      </Link>
      <h2 className="text-gray-600 text-3xl font-semibold my-4">
        General Details
      </h2>

      <Formik
        initialValues={{
          description: '',
          position: '',
          employmentType: '',
          duration: '',
          basicYearlySalary: '',
          minAge: '',
          maxAge: '',

          educationRequirements: [{ description: '', requiredAttainment: '' }],

          skillRequirement: [{ description: '', skill: '', isRequired: false }],

          employmentRequirements: [
            { minYearsExperience: '', experiencePosition: '' },
          ],

          stages: [stageObject],
        }}
        onSubmit={(values) => {
          postJob(id, values)
            .then((data) => {
              if (data == '') alert('Job posted sucessfully.');
            })
            .catch((err) => console.log(err));
        }}
      >
        {({ values, handleChange, handleSubmit }) => (
          <form action="" method={'POST'} onSubmit={handleSubmit}>
            <div className={'flex flex-wrap items-center'}>
              <div className={'p-2 w-1/2 '}>
                <textarea
                  type="text"
                  rows={5}
                  name="description"
                  onChange={handleChange}
                  value={values.description}
                  className={'p-2 border rounded block w-full'}
                  placeholder={'Description'}
                  required
                />
              </div>

              <div className={'p-2 w-1/2 '}>
                <input
                  type="text"
                  name="position"
                  className={'p-2 border rounded block w-full'}
                  placeholder={'Position'}
                  onChange={handleChange}
                  value={values.position}
                  required
                />

                <select
                  name="employmentType"
                  className={'p-2 border rounded block w-full my-1'}
                  placeholder={'Employment Type'}
                  onChange={handleChange}
                  value={values.employmentType}
                >
                  <option value="#">Select One</option>
                  <option value="FULL_TIME">Full Time</option>
                  <option value="PART_TIME">Part Time</option>
                </select>

                <input
                  type="number"
                  name="duration"
                  className={'p-2 border rounded block w-full my-1'}
                  placeholder={'Duration'}
                  onChange={handleChange}
                  value={values.duration}
                  required
                />
              </div>

              <div className={'p-2 w-1/3'}>
                <input
                  type="text"
                  name="basicYearlySalary"
                  className={'p-2 border rounded block w-full my-1'}
                  placeholder={'Basic Yearly Salray'}
                  onChange={handleChange}
                  value={values.basicYearlySalary}
                  required
                />
              </div>

              <div className={'p-2 w-1/3'}>
                <input
                  type="text"
                  name="minAge"
                  className={'p-2 border rounded block w-full my-1'}
                  placeholder={'Min Age'}
                  onChange={handleChange}
                  value={values.minAge}
                  required
                />
              </div>

              <div className={'p-2 w-1/3'}>
                <input
                  type="text"
                  name="maxAge"
                  className={'p-2 border rounded block w-full my-1'}
                  placeholder={'Max Age'}
                  onChange={handleChange}
                  value={values.maxAge}
                  required
                />
              </div>
            </div>

            <div className="mt-6 flex">
              <div className={'w-1/2'}>
                {/* education requirements */}
                <div className={'rounded shadow p-4 bg-white'}>
                  <FieldArray name={'educationRequirements'}>
                    {({ push, remove, insert }) => (
                      <>
                        <div className="p-2 flex justify-between items-center bg-indigo-100">
                          <h2 className="text-indigo-600 font-semibold">
                            Education Requirements
                          </h2>

                          <button
                            type={'button'}
                            className={
                              'flex items-center bg-indigo-600 hover:bg-indigo-700 text-white font-semibold rounded px-4 py-2'
                            }
                            onClick={() =>
                              push({ description: '', requiredAttainment: '' })
                            }
                          >
                            <MdAddCircleOutline size={20} className="mr-2" />{' '}
                            New
                          </button>
                        </div>

                        {values.educationRequirements.length > 0 &&
                          values.educationRequirements.map((ed, idx) => {
                            return (
                              <div
                                key={idx}
                                className={
                                  'p-2 border-dashed border-gray-300 border-2 mt-2'
                                }
                              >
                                <textarea
                                  className="border mt-2 w-full rounded p-2"
                                  name={`educationRequirements.${idx}.description`}
                                  onChange={handleChange}
                                  value={ed.description}
                                  id=""
                                  cols="30"
                                  rows="4"
                                  placeholder="Description"
                                  required
                                />

                                <select
                                  className={'border rounded p-2 mt-1 w-full'}
                                  name={`educationRequirements.${idx}.requiredAttainment`}
                                  onChange={handleChange}
                                  value={ed.requiredAttainment}
                                  type="text"
                                  placeholder={'Required Attainment'}
                                >
                                  <option value="#" defaultValue>
                                    {' '}
                                    Select One
                                  </option>
                                  <option value="DIPLOMA">Diploma</option>
                                  <option value="ASSOCIATE_DEGREE">
                                    Associate Degree
                                  </option>
                                  <option value="BACHELOR">Bachelors</option>
                                  <option value="MASTER">Masters</option>
                                  <option value="PHD">PHD</option>
                                </select>
                              </div>
                            );
                          })}
                      </>
                    )}
                  </FieldArray>
                </div>

                {/* skills requirements */}
                <div className={'rounded shadow p-4 mt-4 bg-white'}>
                  <FieldArray name={'skillRequirement'}>
                    {({ push, remove, insert }) => (
                      <>
                        <div className="p-2 flex justify-between items-center bg-pink-100">
                          <h2 className="text-pink-600 font-semibold">
                            Skill Requirements
                          </h2>

                          <button
                            type={'button'}
                            className={
                              'bg-pink-600 hover:bg-pink-700 text-white font-semibold rounded inline-block px-4 py-2'
                            }
                            onClick={() =>
                              push({
                                description: '',
                                skill: '',
                                isRequired: false,
                              })
                            }
                          >
                            New +
                          </button>
                        </div>

                        {values.skillRequirement.length > 0 &&
                          values.skillRequirement.map((skill, idx) => {
                            return (
                              <div
                                key={idx}
                                className={
                                  'p-2 border-dashed border-gray-300 border-2 mt-2'
                                }
                              >
                                <textarea
                                  className="border mt-2 w-full rounded p-2"
                                  name={`skillRequirement.${idx}.description`}
                                  onChange={handleChange}
                                  value={skill.description}
                                  id=""
                                  cols="30"
                                  rows="4"
                                  placeholder="Description"
                                  required
                                />

                                <input
                                  className={'border rounded p-2 mt-1 w-full'}
                                  name={`skillRequirement.${idx}.skill`}
                                  onChange={handleChange}
                                  value={skill.skill}
                                  type="text"
                                  placeholder={'Skill'}
                                  required
                                />

                                <div>
                                  <input
                                    type="checkbox"
                                    value={skill.isRequired}
                                    name={`skillRequirement.${idx}.isRequired`}
                                    onChange={handleChange}
                                    required
                                  />
                                  <label
                                    className={
                                      'inline-block ml-2 cursor-pointer select-none hover:bg-gray-50'
                                    }
                                  >
                                    isRequired
                                  </label>
                                </div>
                              </div>
                            );
                          })}
                      </>
                    )}
                  </FieldArray>
                </div>
              </div>

              <div className={'ml-6 w-1/2'}>
                {/* Employment requirements */}
                <div className={'rounded shadow p-4 bg-white'}>
                  <FieldArray name={'employmentRequirements'}>
                    {({ push, remove, insert }) => (
                      <>
                        <div className="p-2 flex justify-between items-center bg-yellow-100">
                          <h2 className="text-yellow-600 font-semibold">
                            Employment Requirements
                          </h2>

                          <button
                            type={'button'}
                            className={
                              'bg-yellow-600 hover:bg-yellow-700 text-white font-semibold rounded inline-block px-4 py-2'
                            }
                            onClick={() =>
                              push({
                                minYearsExperience: '',
                                experiencePosition: '',
                              })
                            }
                          >
                            New +
                          </button>
                        </div>

                        {values.employmentRequirements.length > 0 &&
                          values.employmentRequirements.map((em, idx) => {
                            return (
                              <div
                                key={idx}
                                className={
                                  'p-2 border-dashed border-gray-300 border-2 mt-2'
                                }
                              >
                                <input
                                  type={'number'}
                                  min={0}
                                  className="border mt-2 w-full rounded p-2"
                                  name={`employmentRequirements.${idx}.minYearsExperience`}
                                  onChange={handleChange}
                                  value={em.minYearsExperience}
                                  placeholder="Min Years Experience"
                                  required
                                />

                                <input
                                  className={'border rounded p-2 mt-1 w-full'}
                                  name={`employmentRequirements.${idx}.experiencePosition`}
                                  onChange={handleChange}
                                  value={em.experiencePosition}
                                  type="text"
                                  placeholder={'Experience Position'}
                                  required
                                />
                              </div>
                            );
                          })}
                      </>
                    )}
                  </FieldArray>
                </div>

                {/* stages */}
                <div className={'rounded shadow p-4 mt-4 bg-white'}>
                  <FieldArray name={'stages'}>
                    {({ push, remove, insert }) => (
                      <>
                        <div className="p-2 flex justify-between items-center bg-green-100">
                          <h2 className="text-green-600 font-semibold">
                            Stages
                          </h2>

                          <button
                            type={'button'}
                            className={
                              'bg-green-600 hover:bg-green-700 text-white font-semibold rounded inline-block px-4 py-2'
                            }
                            onClick={() => push(stageObject)}
                          >
                            New +
                          </button>
                        </div>

                        {values.stages.length > 0 &&
                          values.stages.map((stage, idx) => {
                            return (
                              <div
                                key={idx}
                                className={
                                  'p-2 border-dashed border-gray-300 border-2 mt-2'
                                }
                              >
                                <input
                                  className="border mt-2 w-full rounded p-2"
                                  name={`stages.${idx}.stageName`}
                                  onChange={handleChange}
                                  value={stage.stageName}
                                  placeholder="Stage Name"
                                  required
                                />

                                <textarea
                                  className={'border rounded p-2 w-full mt-1'}
                                  id=""
                                  cols="30"
                                  rows="4"
                                  name={`stages.${idx}.stageDescription`}
                                  onChange={handleChange}
                                  value={stage.stageDescription}
                                  type="text"
                                  placeholder={'Stage description'}
                                  required
                                />

                                <FieldArray
                                  name={`stages[${idx}].stageComponent`}
                                >
                                  {({ push, insert, remove }) => (
                                    <>
                                      <button
                                        type={'button'}
                                        className={
                                          'border border-yellow-600  text-yellow-600 font-semibold rounded block px-2 py-1 ml-auto mt-2'
                                        }
                                        onClick={() =>
                                          push(stageComponentObject)
                                        }
                                      >
                                        New Component+
                                      </button>

                                      {stage.stageComponent.length > 0 &&
                                        stage.stageComponent.map(
                                          (component, c_idx) => (
                                            <div
                                              className={'border p-2 mt-2'}
                                              key={c_idx}
                                            >
                                              <input
                                                type="text"
                                                placeholder={'name'}
                                                className="border mt-2 w-full rounded p-2"
                                                name={`stages[${idx}].stageComponent.${c_idx}.name`}
                                                value={stage.name}
                                                onChange={handleChange}
                                              />

                                              <input
                                                type="text"
                                                placeholder={'Details'}
                                                className="border mt-2 w-full rounded p-2"
                                                name={`stages[${idx}].stageComponent.${c_idx}.details`}
                                                value={stage.details}
                                                onChange={handleChange}
                                              />

                                              <input
                                                type="date"
                                                placeholder={'Required Date'}
                                                className="border mt-2 w-full rounded p-2"
                                                name={`stages[${idx}].stageComponent.${c_idx}.requiredDate`}
                                                value={stage.requiredDate}
                                                onChange={handleChange}
                                              />

                                              <input
                                                type="date"
                                                placeholder={'End date'}
                                                className="border mt-2 w-full rounded p-2"
                                                name={`stages[${idx}].stageComponent.${c_idx}.endDate`}
                                                value={stage.endDate}
                                                onChange={handleChange}
                                              />
                                            </div>
                                          )
                                        )}
                                    </>
                                  )}
                                </FieldArray>

                                <div>
                                  <input
                                    type="checkbox"
                                    name={`stages.${idx}.isRequired`}
                                    onChange={handleChange}
                                    value={stage.isRequired}
                                    required
                                  />
                                  <label htmlFor="" className={'ml-2'}>
                                    isRequired
                                  </label>
                                </div>
                              </div>
                            );
                          })}
                      </>
                    )}
                  </FieldArray>
                </div>
              </div>
            </div>

            {/* <pre>{JSON.stringify(values, null, 2)}</pre> */}

            <button
              type={'submit'}
              className="p-2 bg-green-700 text-white rounded shadow-lg hover:shadow px-4"
            >
              Submit
            </button>
          </form>
        )}
      </Formik>
    </div>
  );
}
