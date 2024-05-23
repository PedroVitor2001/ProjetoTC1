import React, { useState } from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import Register from "./pages/register";
//import ReadPage from "./pages/readePage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Register />} />
        {/*<Route path="/list" element={<ReadPage />} />
         */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
