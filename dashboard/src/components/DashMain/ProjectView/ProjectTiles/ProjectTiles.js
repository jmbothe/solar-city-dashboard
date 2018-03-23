import React from 'react';
import ProjectCrew from './ProjectCrew/ProjectCrew';
import ProjectDetails from './ProjectDetails/ProjectDetails';
import ProjectNotes from './ProjectNotes/ProjectNotes';

const ProjectTiles = ({
  projectInView,
  crew,
  assignCrewMember,
  updateNotes,
  changeNotes
}) =>
  <section className="project-tiles">
    <ProjectDetails
      projectInView={projectInView}
      crew={crew.filter(member => member.assignedTo == projectInView.projectId)}
    />
    <ProjectCrew
      projectInView={projectInView}
      crew={crew}
      assignCrewMember={assignCrewMember}
    />
    <ProjectNotes
      projectInView={projectInView}
      updateNotes={updateNotes}
      changeNotes={changeNotes}
    />
  </section>
 
export default ProjectTiles;