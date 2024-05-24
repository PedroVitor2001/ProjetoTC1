import { Routes, Route, HashRouter } from "react-router-dom";
import Register from "./pages/register";
import List from "./pages/list";

function App() {
  return (
    <HashRouter>
      {" "}
      <Routes>
        <Route path="/" element={<Register />} />
        <Route path="/list" element={<List />} />
      </Routes>
    </HashRouter>
  );
}

export default App;
