import React from 'react';
import ProjectTiles from './ProjectTiles/ProjectTiles';
import ProjectTimeline from './ProjectTimeline/ProjectTimeline';

const ProjectView = ({
  projectInView,
  toggleMilestone,
  crew,
  assignCrewMember,
  updateNotes,
  changeNotes
}) => 
  <section className="project-view">
    <ProjectTimeline
      projectInView={projectInView}
      toggleMilestone={toggleMilestone}
    />
    <ProjectTiles
      projectInView={projectInView}
      crew={crew}
      assignCrewMember={assignCrewMember}
      updateNotes={updateNotes}
      changeNotes={changeNotes}
    />
  </section>
 
export default ProjectView;