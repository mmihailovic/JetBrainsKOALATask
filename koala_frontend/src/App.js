import './App.css';
import {useState} from "react";

function App() {
  const [breakpoints, setBreakpoints] = useState([]);

  const breakpointIcons = {
    'Java Linetrue': '../assets/breakpoint_dark.svg',
    'Java Linefalse': '../assets/breakpointDisabled_dark.svg',
    'Java Exceptiontrue': '../assets/breakpointException_dark.svg',
    'Java Exceptionfalse': '../assets/breakpointExceptionDisabled_dark.svg',
    'Java Fieldtrue': '../assets/breakpointField_dark.svg',
    'Java Fieldfalse': '../assets/breakpointFieldDisabled_dark.svg',
    'Java Methodtrue': '../assets/breakpointMethod_dark.svg',
    'Java Methodfalse': '../assets/breakpointMethodDisabled_dark.svg',

  };

  window.loadBreakpoints = function(allBreakpoints) {
    setBreakpoints(allBreakpoints)
  };

  window.addBreakpoint = function(breakpoint) {
    setBreakpoints(currentBreakpoints => [...currentBreakpoints, breakpoint])
  }

  window.removeBreakpoint = function (breakpointToRemove) {
    setBreakpoints(currentBreakpoints =>
        currentBreakpoints.filter(breakpoint => breakpoint.identifier !== breakpointToRemove.identifier))
  }

  window.updateBreakpoint = function (updatedBreakpoint) {
    setBreakpoints(currentBreakpoints =>
        currentBreakpoints.map(breakpoint => breakpoint.identifier === updatedBreakpoint.identifier?
            {...breakpoint, ...updatedBreakpoint}: breakpoint))
  }

  return (
      <div>
        <table>
          <thead>
          <tr>
            <th>Breakpoint Type</th>
            <th>Details</th>
          </tr>
          </thead>
          <tbody>
          {breakpoints.map(breakpoint =>
              <tr className={"breakpoint-item"}>
                <td className="breakpoint-type">
                  <div className={"breakpoint"}>
                    <img src={breakpointIcons[breakpoint.type + breakpoint.breakpointEnabled]} alt={""}/>
                    <p>{breakpoint.type}</p>
                  </div>
                </td>
                <td className="breakpoint-details">{breakpoint.details}</td>
              </tr>
          )}
          <th colSpan={2}>Number of breakpoints: {breakpoints.length}</th>
          </tbody>
        </table>
      </div>
  );
}

export default App;
