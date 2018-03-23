import React from 'react';

const ProjectNotes = ({
  updateNotes,
  changeNotes,
  projectInView
}) =>
  <section>
    <div className="tile-heading">
      <h3>Notes</h3>
    </div>
    <textarea rows="4" cols="50"
      onBlur={() => updateNotes(projectInView.projectId)}
      onChange={e => changeNotes(projectInView.projectId, e.target.value)}
      value={projectInView.notes || ''}
      placeholder='Put notes here' 
    >
    </textarea>
  </section>
 
export default ProjectNotes;