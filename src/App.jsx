import { Routes, Route, HashRouter } from "react-router-dom"; // Importe HashRouter
import Register from "./pages/register";
//import ReadPage from "./pages/readePage";

function App() {
  return (
    <HashRouter>
      {" "}
      <Routes>
        <Route path="/" element={<Register />} />
        {/*<Route path="/list" element={<ReadPage />} />
         */}
      </Routes>
    </HashRouter>
  );
}

export default App;
