VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T0 = 4
    parm _T0
    _T1 =  call _Alloc
    _T2 = VTBL <_Main>
    *(_T1 + 0) = _T2
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T6 = 2
    _T4 = _T6
    _T7 = 2
    _T8 = 3
    _T9 = (_T7 - _T8)
    _T5 = _T9
    _T10 = 3
    _T11 = 0
    _T12 = (_T5 < _T11)
    if (_T12 == 0) branch _L10
    _T13 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T13
    call _PrintString
    call _Halt
_L10:
    _T14 = 4
    _T15 = (_T14 * _T5)
    _T16 = (_T14 + _T15)
    parm _T16
    _T17 =  call _Alloc
    *(_T17 + 0) = _T5
    _T18 = 0
    _T17 = (_T17 + _T16)
_L11:
    _T16 = (_T16 - _T14)
    if (_T16 == 0) branch _L12
    _T17 = (_T17 - _T14)
    *(_T17 + 0) = _T18
    branch _L11
_L12:
    _T19 = 4
    _T20 = _T17
    _T21 = (_T5 * _T19)
    _T22 = (_T17 + _T21)
_L13:
    _T23 = (_T20 < _T22)
    if (_T23 == 0) branch _L14
    *(_T20 + 0) = _T10
    _T24 = (_T20 + _T19)
    _T20 = _T24
    branch _L13
_L14:
    _T3 = _T17
    _T25 = 1
    _T26 = *(_T3 - 4)
    _T27 = (_T25 < _T26)
    if (_T27 == 0) branch _L15
    _T28 = 0
    _T29 = (_T25 < _T28)
    if (_T29 == 0) branch _L16
_L15:
    _T30 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T30
    call _PrintString
    call _Halt
_L16:
    _T31 = 4
    _T32 = (_T25 * _T31)
    _T33 = (_T3 + _T32)
    _T34 = *(_T33 + 0)
    _T35 = 1
    _T36 = *(_T3 - 4)
    _T37 = (_T35 < _T36)
    if (_T37 == 0) branch _L17
    _T38 = 0
    _T39 = (_T35 < _T38)
    if (_T39 == 0) branch _L18
_L17:
    _T40 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T40
    call _PrintString
    call _Halt
_L18:
    _T41 = 4
    _T42 = (_T35 * _T41)
    _T43 = (_T3 + _T42)
    _T44 = *(_T43 + 0)
    _T45 = 1
    _T46 = (_T44 + _T45)
    _T47 = 4
    _T48 = (_T25 * _T47)
    _T49 = (_T3 + _T48)
    *(_T49 + 0) = _T46
    _T50 = 0
    _T51 = *(_T3 - 4)
    _T52 = (_T50 < _T51)
    if (_T52 == 0) branch _L19
    _T53 = 0
    _T54 = (_T50 < _T53)
    if (_T54 == 0) branch _L20
_L19:
    _T55 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T55
    call _PrintString
    call _Halt
_L20:
    _T56 = 4
    _T57 = (_T50 * _T56)
    _T58 = (_T3 + _T57)
    _T59 = *(_T58 + 0)
    parm _T59
    call _PrintInt
    _T60 = "\n"
    parm _T60
    call _PrintString
    _T61 = 1
    _T62 = *(_T3 - 4)
    _T63 = (_T61 < _T62)
    if (_T63 == 0) branch _L21
    _T64 = 0
    _T65 = (_T61 < _T64)
    if (_T65 == 0) branch _L22
_L21:
    _T66 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T66
    call _PrintString
    call _Halt
_L22:
    _T67 = 4
    _T68 = (_T61 * _T67)
    _T69 = (_T3 + _T68)
    _T70 = *(_T69 + 0)
    parm _T70
    call _PrintInt
    _T71 = "\n"
    parm _T71
    call _PrintString
}

